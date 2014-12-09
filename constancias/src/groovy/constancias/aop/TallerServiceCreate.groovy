package constancias.aop

import constancias.Taller

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class TallerServiceCreate {

    @Pointcut(
        value='execution(void constancias.TallerService.create(..)) && bean(tallerService) && args(taller)',
        argNames='taller')
    public void create( Taller taller ) {}

    @Before('create(taller)')
    void before( Taller taller ) {
        log.info( "Begins request: ${taller}" )
    }

    @AfterReturning(
        pointcut='create(constancias.Taller)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='create(constancias.Taller)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}