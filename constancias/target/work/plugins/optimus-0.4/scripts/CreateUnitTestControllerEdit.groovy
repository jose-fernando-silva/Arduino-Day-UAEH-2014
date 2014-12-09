import org.apache.commons.lang.WordUtils

includeTargets << new File( optimusPluginDir,
    'scripts/CreateMock.groovy' )

target( createUnitTestControllerEdit:
    "Generate unit tests for 'edit' controller method" ) {

    depends( checkVersion, configureProxy, packageApp, loadApp, configureApp,
        createMock )
    def domainClassList = getDomainClassList( args )
    if ( !domainClassList ) return
    domainClassList.each { generate( it ) }
    def msg = "Finished generation of 'edit' controller unit tests"
    event( 'StatusFinal', [ msg ] )

}// End of closure

setDefaultTarget( createUnitTestControllerEdit )

void generate( domainClass ) {

    def idAssigned = getIdAssigned( domainClass )
    def idName = idAssigned ? idAssigned.name : 'id'
    def content = '' << "package ${domainClass.packageName}\n\n"
    content << generateImports()
    content << generateClassDeclaration( domainClass.name )
    content << generateSetUpMethod( domainClass.name )
    content << generateOkMethod( domainClass.name, idName )
    content << generateIdNullMethod()
    content << generateNotFoundMethod( domainClass.name, idName )
    content << generateRequestMethodInvalidMethod( domainClass.name, idName )
    content << generateGetTemplateMethod( domainClass.name )
    content << generateMockMethods( domainClass.name, idAssigned )
    content << "}${comment('class')}"
    def directory = generateDirectory( "test/unit", domainClass.packageName )
    def filename = "${domainClass.name}ControllerEditSpec.groovy"
    createFile( directory, filename, content.toString() )

}// End of method

String generateImports() {

    def content = '' << "import javax.servlet.http.HttpServletRequest\n"
    content << "import grails.test.GrailsMock\n"
    content << "import grails.test.mixin.*\n"
    content << "import spock.lang.*\n"
    content << "\n"
    content.toString()

}// End of method

String generateClassDeclaration( className ) {

    def content = '' << "@TestFor(${className}Controller)\n"
    content << "@Mock(${className})\n"
    content << "class ${className}ControllerEditSpec"
    content << " extends Specification {\n\n"
    content.toString()

}// End of method

String generateSetUpMethod( className ) {

    def classNameLower = WordUtils.uncapitalize( className )
    def content = '' << "${tab()}def setup() {\n\n"
    content << "${tab()*2}${className}Mock.mock( 0 ).save("
    content << " failOnError:true )\n"
    content << "${tab()*2}views[ '/${classNameLower}/_form.gsp' ]"
    content << " = getTemplate()\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateOkMethod( className, idName ) {

    def id = idName != 'id' ? "${className}Mock.mock( 0 ).${idName}" : '1'
    def classNameLower = WordUtils.uncapitalize( className )
    def content = '' << "${tab()}def \"test ok\"() {\n\n"
    content << "${tab()*2}when:\n"
    content << "${tab()*3}def control = mock${className}Service()\n"
    content << "${tab()*3}request.method = 'GET'\n"
    content << "${tab()*3}def model = controller.edit( ${id} )\n"
    content << "${tab()*3}control.verify()\n"
    content << "${tab()*2}then:\n"
    content << "${tab()*3}response.text == 'OK'\n"
    content << "${tab()*3}response.status == 200\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateIdNullMethod() {

    def content = '' << "${tab()}def \"test id null\"() {\n\n"
    content << "${tab()*2}when:\n"
    content << "${tab()*3}def control = mock"
    content << "${CRACKING_SERVICE.capitalize()}Service()\n"
    content << "${tab()*3}request.method = 'GET'\n"
    content << "${tab()*3}controller.edit( null )\n"
    content << "${tab()*3}control.verify()\n"
    content << "${tab()*2}then:\n"
    content << "${tab()*3}response.redirectedUrl == '/logout'\n"
    content << "${tab()*3}response.status == 302\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateNotFoundMethod( className, idName ) {

    def id = idName != 'id' ? "${className}Mock.mock( 1 ).${idName}" : '2'
    def classNameLower = WordUtils.uncapitalize( className )
    def content = '' << "${tab()}def \"test not found\"() {\n\n"
    content << "${tab()*2}when:\n"
    content << "${tab()*3}def control = mock${className}Service()\n"
    content << "${tab()*3}def control2 = mock"
    content << "${CRACKING_SERVICE.capitalize()}Service()\n"
    content << "${tab()*3}request.method = 'GET'\n"
    content << "${tab()*3}controller.edit( ${id} )\n"
    content << "${tab()*3}control.verify()\n"
    content << "${tab()*3}control2.verify()\n"
    content << "${tab()*2}then:\n"
    content << "${tab()*3}response.redirectedUrl == '/logout'\n"
    content << "${tab()*3}response.status == 302\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateRequestMethodInvalidMethod( className, idName ) {

    def id = idName != 'id' ? "${className}Mock.mock( 1 ).${idName}" : '2'
    def content = '' << "${tab()}@Ignore( 'See http://jira.grails.org/browse/"
    content << "GRAILS-8426' )\n"
    content << "${tab()}def \"test request method invalid\"() {\n\n"
    content << "${tab()*2}when:\n"
    content << "${tab()*3}request.method = 'POST'\n"
    content << "${tab()*3}controller.edit( ${id} )\n"
    content << "${tab()*2}then:\n"
    content << "${tab()*3}response.status == 405\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateGetTemplateMethod( className ) {

    def classNameLower = WordUtils.uncapitalize( className )
    def content = '' << "${tab()}private String getTemplate() {\n"
    content << "${tab()*2}'<g:if test=\"\${${classNameLower}Instance}\">OK</g:if>"
    content << "<g:else>ERROR</g:else>'\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateMockMethods( className, idAssigned ) {

    def content = new StringBuilder()
    content << generateMockServiceMethod( className, idAssigned )
    content << generateCrackingServiceMethod()
    content.toString()

}// End of method

String generateMockServiceMethod( className, idAssigned ) {

    def idName = idAssigned ? idAssigned.name : 'id'
    def idType = idAssigned ? idAssigned.type : 'Long'
    def classNameLower = WordUtils.uncapitalize( className )
    def content = '' << "${tab()}private GrailsMock"
    content << " mock${className}Service() {\n\n"
    content << "${tab()*2}def control = mockFor( ${className}Service )\n"
    content << "${tab()*2}control.demand.get( 1 ) { ${idType} id ->\n"
    content << "${tab()*3}${className}.findBy${idName.capitalize()}( id )\n"
    content << "${tab()*2}}${comment('closure')}\n"
    content << "${tab()*2}controller.${classNameLower}Service = "
    content << "control.createMock()\n"
    content << "${tab()*2}control\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method

String generateCrackingServiceMethod() {

    def content = '' << "${tab()}private GrailsMock"
    content << " mock${CRACKING_SERVICE.capitalize()}Service() {\n\n"
    content << "${tab()*2}def control = mockFor("
    content << " ${CRACKING_SERVICE.capitalize()}Service )\n"
    content << "${tab()*2}control.demand.notify( 1 ) {"
    content << " HttpServletRequest request, Map params -> }\n"
    content << "${tab()*2}controller.${CRACKING_SERVICE}Service = "
    content << "control.createMock()\n"
    content << "${tab()*2}control\n\n"
    content << "${tab()}}${comment('method')}\n\n"
    content.toString()

}// End of method
