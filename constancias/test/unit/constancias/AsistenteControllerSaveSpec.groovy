package constancias

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(AsistenteController)
@Mock(Asistente)
class AsistenteControllerSaveSpec extends Specification {

    def setup() {
        views[ '/asistente/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockAsistenteService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/asistente/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockAsistenteService( false )
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
        '<g:if test="${asistenteInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockAsistenteService( save = true ) {

        def control = mockFor( AsistenteService )
        control.demand.create( 1 ) { Asistente instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.asistenteService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = AsistenteMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}