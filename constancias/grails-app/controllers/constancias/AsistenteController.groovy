package constancias

class AsistenteController {

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

    def asistenteService
    def crackingService
    def pdfService

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

        def model = [ asistenteInstance:new Asistente( params ) ]
        render( template:'form', model:model )

    }

    def save() {

        def asistente = new Asistente( params )
        saveOnDb( asistente, 'create' )

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
        map.asistenteInstance.properties = params
        map.edit = true
        saveOnDb( map.asistenteInstance, 'update', true )

    }

    def delete( Long id ) {

        def map = get( id )
        if ( !map ) return
        asistenteService.delete( map.asistenteInstance )
        flash.listMessage = message( code:'default.deleted.message',
            args:[ message( code:'asistente.label',
            default:'Asistente' ), id ] )
        redirect( action:'content' )

    }

    private void renderList( template ) {

        def model = [:]
        def result = asistenteService.list( params )
        model.items = result.items
        model.total = result.total
        render( template:template, model:model )

    }

    private Map get( Long id ) {

        if ( id == null ) {
            notifyCrack()
            return null
        }
        def asistente = asistenteService.get( id )
        if ( !asistente ) {
            notifyCrack()
            return null
        }
        [ asistenteInstance:asistente ]

    }

    private void saveOnDb( asistente, method, edit = false ) {

        try {
            asistenteService."${method}"( asistente )
        } catch ( IllegalArgumentException e ) {
            response.status = 400
            render( template:'form', model:[ asistenteInstance:asistente,
                edit:edit ] )
            return
        }
        flash.formMessage = message(
            code:"default.${edit?'updated':'created'}.message",
            args:[ message( code:'asistente.label',
            default:'Asistente' ), asistente.id])
        redirect( action:'edit', id:asistente.id )

    }

    private void notifyCrack() {

        crackingService.notify( request, params )
        redirect( controller:'logout' )

    }

    def asistencia() {
        render template: "asistencia"
    }

    def buscarFolio() {
        try {
            def noFolio = Integer.parseInt(params.folio)
            def asistente = Asistente.get(noFolio)
            if(asistente) {
                if(asistente.asistencia) {
                    render "<div class='alert alert-info'>${asistente}, ya tiene asistencia</div>"
                } else {
                    render template: "asistente", model: [asistente: asistente]    
                }
            } else {
                render "<div class='alert alert-danger'>El Número de Folio ${noFolio} no existe</div>"    
            }
        } catch(NumberFormatException e) {
            render "<div class='alert alert-danger'>Ocurrio un error</div>"
        }
    }

    def tomarAsistencia() {
        def asistente = Asistente.get(params.folio)
        asistente.asistencia = true
        try {
            int id = Integer.parseInt(params.taller.id)
            asistente.taller = Taller.get(id)
        } catch(NumberFormatException e){}
        asistente.save()
        if(asistente.asistencia) {
            render "<div class='alert alert-success'>Hecho, ${asistente} ya tiene asistencia</div>"
        } else {
            render "<div class='alert alert-danger'>Ocurrio un error al procesar la asistencia de ${asistente}</div>"
        }
    }   

    def mandarMensaje() {
        def cantidadConstancias
        try {
            cantidadConstancias = Integer.parseInt(params.cantidadConstanciasAEnviar)    
        } catch(NumberFormatException e) {}
        
        def asistentes = Asistente.findAllByAsistenciaAndConstancia(true, false, [max: cantidadConstancias])
        def noEnviados = 0

        asistentes.each { asistente ->
            def archivo = generarPDF(asistente)
            if(archivo != null) {
                try {
                    sendMail {  
                        multipart true   
                        //to asistente.correoElectronico
                        to "parientefernandox@hotmail.com"
                        //to "joseh12341234@gmail.com"
                        subject "Constancia Arduino Day UAEH 2014"     
                        html view: "email", model: [asistente: asistente]
                        attach 'constancia-arduino-day','application/pdf', archivo
                    }
                    println "Correo mandado exitosamente a ${asistente} al correo ${asistente.correoElectronico}"
                    asistente.constancia = true
                    noEnviados++;
                } catch(Exception e) {
                    println "Error al mandar el correo a ${asistente}: " + e
                }
            } else {
                println "Hubo problemas al crear archivo de ${asistente}"
            }
        }    
        flash.message = "Número de constancias enviadas: ${noEnviados}"
        redirect action: "constancias"
    }

    def generarPDF(asistente) {   
        try {
            byte[] b
            def baseUri = g.createLink(uri: "/", absolute:"true").toString()
            def content = g.render(template: "constancia", model: [name: asistente])
            b = pdfService.buildPdfFromString(content.readAsString(), baseUri)

            //Crea archivo pdf
            def nombreArchivo = "web-app/docs/Folio-${asistente.id}"
            def archivo = new File(nombreArchivo)    
            archivo.setBytes(b)
            println "Se creo el archivo ${nombreArchivo}, de ${asistente}"
            return archivo
        } catch(Exception e) {
            println "Error al crear archivo de ${asistente}: " + e
        }    
        return null
    }

    def constancias() {
        def totalAsistentes = Asistente.countByAsistencia(true)
        def constanciasEnviadas = Asistente.countByAsistenciaAndConstancia(true, true)
        def asistentesSinConstancia = Asistente.findAllByConstanciaAndAsistencia(false, true)
        render template: "constancias", model:[totalAsistentes: totalAsistentes, constanciasEnviadas: constanciasEnviadas,asistentesSinConstancia: asistentesSinConstancia]
    }
}