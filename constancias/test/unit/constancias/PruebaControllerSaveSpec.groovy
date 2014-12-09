package constancias

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(PruebaController)
@Mock(Prueba)
class PruebaControllerSaveSpec extends Specification {

    def setup() {
        views[ '/prueba/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockPruebaService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/prueba/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockPruebaService( false )
            request.method = 'POST'
            setUpParams()
            params.nombres = null
            controller.save()
            control.verify()
        then:
            response.text == 'OK'
            response.status == 400

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'GET'
            controller.save()
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${pruebaInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockPruebaService( save = true ) {

        def control = mockFor( PruebaService )
        control.demand.create( 1 ) { Prueba instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.pruebaService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = PruebaMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}