package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(PruebaService)
@Mock(Prueba)
class PruebaServiceCreateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = PruebaMock.mock( 0 )
            service.create( instance )
        then:
            Prueba.count() == 1

    }

    def "test Prueba null"() {

        when:
            def instance = null
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'prueba' is null"

    }

    def "test Prueba invalid"() {

        when:
            def instance = PruebaMock.mock( 0 )
            instance.nombres = nombres
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'prueba' is invalid"
        where:
            nombres = null

    }

}