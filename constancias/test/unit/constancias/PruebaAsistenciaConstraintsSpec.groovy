package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaAsistenciaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( asistencia:asistencia )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'asistencia' ] != null
            instance.errors[ 'asistencia' ] == 'nullable'
        where:
            asistencia = null

    }

}