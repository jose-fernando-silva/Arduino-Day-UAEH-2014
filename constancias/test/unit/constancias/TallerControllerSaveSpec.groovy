package constancias

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(TallerController)
@Mock(Taller)
class TallerControllerSaveSpec extends Specification {

    def setup() {
        views[ '/taller/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockTallerService()
            request.method = 'POST'
            setUpParams()
            controller.save()
            control.verify()
        then:
            flash.formMessage == 'default.created.message'
            response.redirectedUrl == "/taller/edit/1"
            response.status == 302

    }

    def "test params invalid"() {

        when:
            def control = mockTallerService( false )
            request.method = 'POST'
            setUpParams()
            params.nombre = null
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
        '<g:if test="${tallerInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockTallerService( save = true ) {

        def control = mockFor( TallerService )
        control.demand.create( 1 ) { Taller instance ->
            if ( save ) {
                instance.id = 1
                instance.save( failOnError:true )
            } else throw new IllegalArgumentException( 'error' )
        }
        controller.tallerService = control.createMock()
        control

    }

    private void setUpParams() {

        def mock = TallerMock.mock( 0 )
        mock.properties.each{ params."${it.key}" = it.value }

    }

}