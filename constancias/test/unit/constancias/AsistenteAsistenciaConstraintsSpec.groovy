package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Asistente)
class AsistenteAsistenciaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Asistente, [ new Asistente() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Asistente( asistencia:asistencia )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'asistencia' ] != null
            instance.errors[ 'asistencia' ] == 'nullable'
        where:
            asistencia = null

    }

}