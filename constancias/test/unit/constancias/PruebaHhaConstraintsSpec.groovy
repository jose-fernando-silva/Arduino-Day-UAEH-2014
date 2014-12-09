package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaHhaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( hha:hha )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'hha' ] != null
            instance.errors[ 'hha' ] == 'nullable'
        where:
            hha = null

    }

}