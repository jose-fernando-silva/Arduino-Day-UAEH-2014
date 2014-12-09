package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(TallerService)
@Mock(Taller)
class TallerServiceDeleteSpec extends Specification {

    def setup() {
        TallerMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Taller.count() == 0
        where:
            id = 1

    }

    void "test Taller null"() {

        when:
            service.delete( taller )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'taller' is null"
        where:
            taller = null

    }

    def " test invalid"() {

        when:
            def instance = new Taller()
            service.delete( instance )
        then:
            Taller.exists( instance.id ) == false

    }

}