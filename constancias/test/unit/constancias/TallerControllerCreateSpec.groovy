package constancias

import grails.test.mixin.*
import spock.lang.*

@TestFor(TallerController)
class TallerControllerCreateSpec extends Specification {

    def setup() {
        views[ '/taller/_form.gsp' ] = getTemplate()
    }

    def "test ok"() {

        when:
            request.method = 'GET'
            def model = controller.create()
        then:
            response.text == 'OK'
            response.status == 200

    }

    @Ignore( 'See http://jira.grails.org/browse/GRAILS-8426' )
    def "test request method invalid"() {

        when:
            request.method = 'POST'
            controller.create()
        then:
            response.status == 405

    }

    private String getTemplate() {
        '<g:if test="${tallerInstance}">OK</g:if><g:else>ERROR</g:else>'
    }

}