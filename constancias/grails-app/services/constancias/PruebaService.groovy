package constancias

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class PruebaService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Prueba ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Prueba prueba ) {
        save( prueba )
    }

    void update( Prueba prueba ) {
        save( prueba )
    }

    Prueba get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Prueba.findById( id )

    }

    void delete( Prueba prueba ) {

        if ( prueba == null ) throw new IllegalArgumentException(
            "Parameter 'prueba' is null" )
        prueba.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'nombres', 'apellidos', 'correoElectronico', 'nivelAcademico', 'constancia', 'asistencia', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Prueba prueba ) {

        if ( !prueba ) throw new IllegalArgumentException(
            "Parameter 'prueba' is null" )
        try {
            prueba.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'prueba' is invalid" )
        }

    }

}