includeTargets << new File( optimusPluginDir,
    'scripts/CreateUnitTestConstraints.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateServiceClass.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateUnitTestService.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateLogs.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateControllerClass.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateUnitTestController.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateViews.groovy' )
includeTargets << new File( optimusPluginDir,
    'scripts/CreateI18n.groovy' )

target( createAll:'Generate all domain artifacts' ) {
    depends( checkVersion, configureProxy, packageApp, loadApp, configureApp,
        createUnitTestConstraints,
        createServiceClass,
        createUnitTestService,
        createLogs,
        createControllerClass, 
        createUnitTestController,
        createViews,
        createI18n )
    def msg = "Finished generation of domain artifacts"
    event( 'StatusFinal', [ msg ] )

}// End of closure

setDefaultTarget( createAll )
