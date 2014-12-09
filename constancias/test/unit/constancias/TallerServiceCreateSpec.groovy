package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(TallerService)
@Mock(Taller)
class TallerServiceCreateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = TallerMock.mock( 0 )
            service.create( instance )
        then:
            Taller.count() == 1

    }

    def "test Taller null"() {

        when:
            def instance = null
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'taller' is null"

    }

    def "test Taller invalid"() {

        when:
            def instance = TallerMock.mock( 0 )
            instance.nombre = nombre
            service.create( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'taller' is invalid"
        where:
            nombre = null

    }

}