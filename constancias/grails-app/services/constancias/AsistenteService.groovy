package constancias

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class AsistenteService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Asistente ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Asistente asistente ) {
        save( asistente )
    }

    void update( Asistente asistente ) {
        save( asistente )
    }

    Asistente get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Asistente.findById( id )

    }

    void delete( Asistente asistente ) {

        if ( asistente == null ) throw new IllegalArgumentException(
            "Parameter 'asistente' is null" )
        asistente.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'nombres', 'apellidos', 'correoElectronico', 'nivelAcademico', 'constancia', 'asistencia', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Asistente asistente ) {

        if ( !asistente ) throw new IllegalArgumentException(
            "Parameter 'asistente' is null" )
        try {
            asistente.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'asistente' is invalid" )
        }

    }

}