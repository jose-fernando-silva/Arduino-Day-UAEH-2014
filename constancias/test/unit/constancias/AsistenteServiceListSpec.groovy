package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(AsistenteService)
@Mock(Asistente)
class AsistenteServiceListSpec extends Specification {

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