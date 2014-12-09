package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(PruebaService)
@Mock(Prueba)
class PruebaServiceListSpec extends Specification {

    def "test ok"() {

        when:
            def result = service.list( params )
        then:
            result.items != null
            result.total != null
        where:
            params = [:]

    }

}