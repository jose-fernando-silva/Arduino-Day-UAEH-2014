package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Asistente)
class AsistenteConstanciaConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Asistente, [ new Asistente() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Asistente( constancia:constancia )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'constancia' ] != null
            instance.errors[ 'constancia' ] == 'nullable'
        where:
            constancia = null

    }

}