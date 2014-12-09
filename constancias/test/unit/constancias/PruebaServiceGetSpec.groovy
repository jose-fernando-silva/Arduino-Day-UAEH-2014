package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(PruebaService)
@Mock(Prueba)
class PruebaServiceGetSpec extends Specification {

    def setup() {
        PruebaMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def result = service.get( id )
        then:
            result != null
        where:
            id = 1

    }

    void "test Id null"() {

        when:
            service.get( id )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'id' is null"
        where:
            id = null

    }

    def " test not found"() {

        when:
            def result = service.get( id )
        then:
            result == null
        where:
            id = 2

    }

}