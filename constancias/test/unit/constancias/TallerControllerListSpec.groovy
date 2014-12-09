package constancias

import grails.test.GrailsMock
import grails.test.mixin.*
import spock.lang.*

@TestFor(TallerController)
class TallerControllerListSpec extends Specification {

    def setup() {
        views[ '/taller/_list.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            def control = mockTallerService()
            request.method = 'GET'
            def model = controller.list()
        control.verify()

        then:
            response.text == 'OK'
            response.status == 200

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'POST'
            controller.list()
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${items && total}">OK</g:if><g:else>ERROR</g:else>'
    }

    private GrailsMock mockTallerService() {

        def control = mockFor( TallerService )
        control.demand.list( 1 ) { Map params ->
            [ items:[ new Taller() ], total:1 ] }
        controller.tallerService = control.createMock()
        control

    }

}