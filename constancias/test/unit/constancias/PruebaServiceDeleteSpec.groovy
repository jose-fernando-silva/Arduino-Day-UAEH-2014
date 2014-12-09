package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(PruebaService)
@Mock(Prueba)
class PruebaServiceDeleteSpec extends Specification {

    def setup() {
        PruebaMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Prueba.count() == 0
        where:
            id = 1

    }

    void "test Prueba null"() {

        when:
            service.delete( prueba )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'prueba' is null"
        where:
            prueba = null

    }

    def " test invalid"() {

        when:
            def instance = new Prueba()
            service.delete( instance )
        then:
            Prueba.exists( instance.id ) == false

    }

}