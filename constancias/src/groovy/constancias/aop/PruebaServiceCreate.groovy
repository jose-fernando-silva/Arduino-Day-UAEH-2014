package constancias.aop

import constancias.Prueba

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class PruebaServiceCreate {

    @Pointcut(
        value='execution(void constancias.PruebaService.create(..)) && bean(pruebaService) && args(prueba)',
        argNames='prueba')
    public void create( Prueba prueba ) {}

    @Before('create(prueba)')
    void before( Prueba prueba ) {
        log.info( "Begins request: ${prueba}" )
    }

    @AfterReturning(
        pointcut='create(constancias.Prueba)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='create(constancias.Prueba)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}