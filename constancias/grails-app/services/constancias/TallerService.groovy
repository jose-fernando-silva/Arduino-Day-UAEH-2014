package constancias

import grails.gorm.DetachedCriteria
import grails.validation.ValidationException

class TallerService {

    Map list( Map params ) {

        processParams( params )
        def criteria = new DetachedCriteria( Taller ).build {}
        [ items:criteria.list( params ), total:criteria.count() ]

    }

    void create( Taller taller ) {
        save( taller )
    }

    void update( Taller taller ) {
        save( taller )
    }

    Taller get( Long id ) {

        if ( id == null ) throw new IllegalArgumentException(
            "Parameter 'id' is null" )
        Taller.findById( id )

    }

    void delete( Taller taller ) {

        if ( taller == null ) throw new IllegalArgumentException(
            "Parameter 'taller' is null" )
        taller.delete()

    }

    private void processParams( params ) {

        params.max = ListUtils.parseMax( params.max )
        params.offset = ListUtils.parseOffset( params.offset )
        params.order = ListUtils.parseOrder( params.order )
        def fields = [ 'nombre', 'numeroLugares', 'id' ]
        params.sort = ListUtils.parseSort( params.sort, fields )

    }

    private void save( Taller taller ) {

        if ( !taller ) throw new IllegalArgumentException(
            "Parameter 'taller' is null" )
        try {
            taller.save( failOnError:true )
        } catch ( ValidationException ) {
            throw new IllegalArgumentException(
                "Parameter 'taller' is invalid" )
        }

    }

}