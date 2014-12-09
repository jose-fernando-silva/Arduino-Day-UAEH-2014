package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(Asistente)
class AsistenteNivelAcademicoConstraintsSpec extends Specification {

    def setup() {
        mockForConstraintsTests( Asistente, [ new Asistente() ] )
    }

    def "test 'nullable' constraint"() {

        when:
            def instance = new Asistente( nivelAcademico:nivelAcademico )
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
            def instance = new Asistente( nivelAcademico:nivelAcademico )
            def result = instance.validate()
        then:
            result == false
            instance.errors[ 'nivelAcademico' ] != null
            instance.errors[ 'nivelAcademico' ] == 'inList'
        where:
            nivelAcademico = 'AOHITXKZFP'

    }

}