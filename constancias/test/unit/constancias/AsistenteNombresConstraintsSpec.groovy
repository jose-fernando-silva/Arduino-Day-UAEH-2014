package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Asistente)
class AsistenteNombresConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Asistente, [ new Asistente() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Asistente( nombres:nombres )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombres' ] != null
            instance.errors[ 'nombres' ] == 'nullable'
        where:
            nombres = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Asistente( nombres:nombres )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombres' ] != null
            instance.errors[ 'nombres' ] == 'maxSize'
        where:
            nombres = 'A' * 31

    }

}