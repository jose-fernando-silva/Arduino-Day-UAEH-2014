package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(AsistenteService)
@Mock(Asistente)
class AsistenteServiceDeleteSpec extends Specification {

    def setup() {
        AsistenteMock.mock( 0 ).save( failOnError:true )
    }

    def " test ok"() {

        when:
            def instance = service.get( id )
            service.delete( instance )
        then:
            Asistente.count() == 0
        where:
            id = 1

    }

    void "test Asistente null"() {

        when:
            service.delete( asistente )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'asistente' is null"
        where:
            asistente = null

    }

    def " test invalid"() {

        when:
            def instance = new Asistente()
            service.delete( instance )
        then:
            Asistente.exists( instance.id ) == false

    }

}