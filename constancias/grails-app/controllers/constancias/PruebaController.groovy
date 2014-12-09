package constancias

class PruebaController {

    static allowedMethods = [
        index:'GET',
        content:'GET',
        list:'GET',
        create:'GET',
        save:'POST',
        edit:'GET',
        update:'POST',
        delete:'POST'
    ]

    def pruebaService
    def crackingService

    def index() {
        redirect( action:'content', params:params )
    }

    def content() {
        renderList( 'content' )
    }

    def list() {
        renderList( 'list' )
    }

    def create() {

        def model = [ pruebaInstance:new Prueba( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def prueba = new Prueba( params )
        saveOnDb( prueba, 'create' )

    }

    def edit( Long id ) {

        def map = get( id )
        if ( !map ) return
        map.edit = true
        render( template:'form', model:map )

    }

    def update( Long id ) {

        def map = get( id )
        if ( !map ) return
        map.pruebaInstance.properties = params
        map.edit = true
        saveOnDb( map.pruebaInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        pruebaService.delete( map.pruebaInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'prueba.label',
            default:'Prueba' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = pruebaService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def prueba = pruebaService.get( id )
        if ( !prueba ) {
            notifyCrack()
            return null
        }
        [ pruebaInstance:prueba ]

    }

    private void saveOnDb( prueba, method, edit = false ) {

        try {
            pruebaService."${method}"( prueba )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ pruebaInstance:prueba,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'prueba.label',
            default:'Prueba' ), prueba.id])
        redirect( action:'edit', id:prueba.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

}