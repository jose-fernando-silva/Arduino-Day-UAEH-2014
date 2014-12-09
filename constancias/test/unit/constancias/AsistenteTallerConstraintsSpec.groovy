package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Asistente)
class AsistenteTallerConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Asistente, [ new Asistente() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Asistente( taller:taller )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'taller' ] == null
        where:
            taller = null

    }

}