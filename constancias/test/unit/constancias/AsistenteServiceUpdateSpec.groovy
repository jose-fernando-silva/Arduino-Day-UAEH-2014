package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(AsistenteService)
@Mock(Asistente)
class AsistenteServiceUpdateSpec extends Specification {

    def "test ok"() {

        when:
            def instance = AsistenteMock.mock( 0 )
            service.update( instance )
        then:
            Asistente.count() == 1

    }

    def "test Asistente null"() {

        when:
            def instance = null
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'asistente' is null"

    }

    def "test Asistente invalid"() {

        when:
            def instance = AsistenteMock.mock( 0 )
            instance.nombres = nombres
            service.update( instance )
        then:
            IllegalArgumentException e = thrown()
            e.message == "Parameter 'asistente' is invalid"
        where:
            nombres = null
    }

}