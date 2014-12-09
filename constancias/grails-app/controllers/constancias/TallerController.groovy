package constancias

class TallerController {

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

    def tallerService
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

        def model = [ tallerInstance:new Taller( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def taller = new Taller( params )
        saveOnDb( taller, 'create' )

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
        map.tallerInstance.properties = params
        map.edit = true
        saveOnDb( map.tallerInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        tallerService.delete( map.tallerInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'taller.label',
            default:'Taller' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = tallerService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def taller = tallerService.get( id )
        if ( !taller ) {
            notifyCrack()
            return null
        }
        [ tallerInstance:taller ]

    }

    private void saveOnDb( taller, method, edit = false ) {

        try {
            tallerService."${method}"( taller )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ tallerInstance:taller,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'taller.label',
            default:'Taller' ), taller.id])
        redirect( action:'edit', id:taller.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

    def x() {
        def html = ""
        withHttp(uri: "http://www.resultados-futbol.com") {
           html = get(path : '/scripts/api/api.php', query : [key:'da95abe34cc4ef99f9df8d0c2b0898c1',format:'json',req:'leagues',country:'es'])
        }
        render html
    }

    def talleresCuenta() {
        render template: "talleresCuenta", model: [talleres: Taller.list()]
    }

    def buscarAlumnosTaller() {
        def taller = Taller.get(params.taller)
        def asistentes = Asistente.findAllByTaller(taller)
        render template: "listaAlumnoTaller", model: [asistentes: asistentes, total: asistentes.size()]
    }

}