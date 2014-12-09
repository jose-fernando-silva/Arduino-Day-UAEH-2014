package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Taller)
class TallerNombreConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Taller, [ new Taller() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Taller( nombre:nombre )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombre' ] != null
            instance.errors[ 'nombre' ] == 'nullable'
        where:
            nombre = null

    }

    def "test 'maxSize' constraint"() {

        when:
            def instance = new Taller( nombre:nombre )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nombre' ] != null
            instance.errors[ 'nombre' ] == 'maxSize'
        where:
            nombre = 'A' * 51

    }

}