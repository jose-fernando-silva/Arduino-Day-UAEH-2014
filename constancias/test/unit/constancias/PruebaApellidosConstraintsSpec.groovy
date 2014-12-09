package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaApellidosConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( apellidos:apellidos )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'apellidos' ] != null
            instance.errors[ 'apellidos' ] == 'nullable'
        where:
            apellidos = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Prueba( apellidos:apellidos )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'apellidos' ] != null
            instance.errors[ 'apellidos' ] == 'maxSize'
        where:
            apellidos = 'A' * 31

    }

}