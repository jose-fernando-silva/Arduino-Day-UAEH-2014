package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Taller)
class TallerNumeroLugaresConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Taller, [ new Taller() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Taller( numeroLugares:numeroLugares )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'numeroLugares' ] != null
            instance.errors[ 'numeroLugares' ] == 'nullable'
        where:
            numeroLugares = null

    }

}