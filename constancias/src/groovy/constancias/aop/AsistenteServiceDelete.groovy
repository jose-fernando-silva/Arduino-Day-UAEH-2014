package constancias.aop

import constancias.Asistente

import org.aspectj.lang.annotation.AfterReturning
import org.aspectj.lang.annotation.AfterThrowing
import org.aspectj.lang.annotation.Aspect
import org.aspectj.lang.annotation.Before
import org.aspectj.lang.annotation.Pointcut

import org.springframework.stereotype.Component

@Component
@Aspect
class AsistenteServiceDelete {

    @Pointcut(
        value='execution(void constancias.AsistenteService.delete(..)) && bean(asistenteService) && args(asistente)',
        argNames='asistente')
    public void delete( Asistente asistente ) {}

    @Before('delete(asistente)')
    void before( Asistente asistente ) {
        log.info( "Begins request:${asistente}" )
    }

    @AfterReturning(
        pointcut='delete(constancias.Asistente)')
    void afterReturning() {
        log.info( "End of request" )
    }

    @AfterThrowing(
        pointcut='delete(constancias.Asistente)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}