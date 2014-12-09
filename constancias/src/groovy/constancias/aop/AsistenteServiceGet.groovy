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
class AsistenteServiceGet {

    @Pointcut(
        value='execution(constancias.Asistente constancias.AsistenteService.get(..)) && bean(asistenteService) && args(id)',
        argNames='id')
    public void getMethod( Long id ) {}

    @Before('getMethod(id)')
    void before( Long id ) {
        log.info( "Begins request:${id}" )
    }

    @AfterReturning(
        pointcut='getMethod(Long)',
        returning='asistente')
    void afterReturning( Asistente asistente ) {
        log.info( "End of request: ${asistente}" )
    }

    @AfterThrowing(
        pointcut='getMethod(Long)',
        throwing='e' )
    void afterThrowing( Exception e ) {

        def message = '' << ''
        message << "Error in request"
        message << ": ${e.class.simpleName} - ${e.message}"
        log.info( message.toString() )

    }

}