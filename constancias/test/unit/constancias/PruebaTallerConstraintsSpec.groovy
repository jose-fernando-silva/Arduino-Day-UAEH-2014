package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaTallerConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( taller:taller )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'taller' ] == null
        where:
            taller = null

    }

}