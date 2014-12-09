package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaCorreoElectronicoConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( correoElectronico:correoElectronico )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'correoElectronico' ] != null
            instance.errors[ 'correoElectronico' ] == 'nullable'
        where:
            correoElectronico = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Prueba( correoElectronico:correoElectronico )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'correoElectronico' ] != null
            instance.errors[ 'correoElectronico' ] == 'maxSize'
        where:
            correoElectronico = 'A' * 51

    }

    def "test 'email' constraint"() {

        when:
            def instance = new Prueba( correoElectronico:correoElectronico )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'correoElectronico' ] != null
            instance.errors[ 'correoElectronico' ] == 'email'
        where:
            correoElectronico = 'A'

    }

}