package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Prueba)
class PruebaNivelAcademicoConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Prueba, [ new Prueba() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Prueba( nivelAcademico:nivelAcademico )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nivelAcademico' ] != null
            instance.errors[ 'nivelAcademico' ] == 'nullable'
        where:
            nivelAcademico = null

    }

    def "test 'inList' constraint"() {

        when:
            def instance = new Prueba( nivelAcademico:nivelAcademico )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nivelAcademico' ] != null
            instance.errors[ 'nivelAcademico' ] == 'inList'
        where:
            nivelAcademico = 'ULBVHYXOVE'

    }

}