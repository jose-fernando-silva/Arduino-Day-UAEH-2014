package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(AsistenteService)
@Mock(Asistente)
class AsistenteServiceListSortOrderSpec extends Specification {

    def setup() {

        20.times {
            AsistenteMock.mock( it + 1 ).save( failOnError:true )
        }

    }

    def "test ok"() {

        when:
            def result = service.list( params )
        then:
            result.items[ 0 ].id == 20
        where:
            params = [ sort:'id', order:'desc' ]

    }

    def "test null"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ sort:null, order:null ]

    }

    def "test blank"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ sort:'', order:'' ]

    }

    def "test invalid"() {

        when:
            def result = service.list( params )
        then:
            result.items.size() == 10
        where:
            params = [ sort:'A', order:'A' ]

    }

}