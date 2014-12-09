package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(TallerService)
@Mock(Taller)
class TallerServiceUpdateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = TallerMock.mock( 0 )
            service.update( instance )
        then:
            Taller.count() == 1

    }

    def "test Taller null"() {

        when:
            def instance = null
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'taller' is null"

    }

    def "test Taller invalid"() {

        when:
            def instance = TallerMock.mock( 0 )
            instance.nombre = nombre
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'taller' is invalid"
        where:
            nombre = null
    }

}