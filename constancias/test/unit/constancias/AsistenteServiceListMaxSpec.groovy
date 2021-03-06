package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(AsistenteService)
@Mock(Asistente)
class AsistenteServiceListMaxSpec extends Specification {

    def setup() {

        20.times {
            AsistenteMock.mock( it ).save( failOnError:true )
        }

    }

    def "test low value"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 9
        where:
            params = [ max:'9' ]

    }

    def "test high value"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ max:'11' ]

    }

    def "test null"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ max:null ]

    }

    def "test blank"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ max:'' ]

    }

    def "test invalid"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ max:'A' ]

    }

}