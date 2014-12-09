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
class PruebaServiceUpdate {

    @Pointcut(
        value='execution(void constancias.PruebaService.update(..)) && bean(pruebaService) && args(prueba)',
        argNames='prueba')
    public void update( Prueba prueba ) {}

    @Before('update(prueba)')
    void before( Prueba prueba ) {
        log.info( "Begins request: ${prueba}" )
    }

    @AfterReturning(
        pointcut='update(constancias.Prueba)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='update(constancias.Prueba)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}