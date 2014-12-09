package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaNombresConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( nombres:nombres )
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
            def instance = new Prueba( nombres:nombres )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombres' ] != null
            instance.errors[ 'nombres' ] == 'maxSize'
        where:
            nombres = 'A' * 31

    }

}