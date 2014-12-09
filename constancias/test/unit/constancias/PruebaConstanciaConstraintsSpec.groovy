package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaConstanciaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( constancia:constancia )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'constancia' ] != null
            instance.errors[ 'constancia' ] == 'nullable'
        where:
            constancia = null

    }

}