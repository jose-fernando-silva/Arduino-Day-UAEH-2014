<g:set var="entityName" value="${message(code: 'asistente.label', default: 'Asistente')}" />
<div class="panel panel-info">
  <div class="panel-heading">
    <g:if test="${edit}">
    <h1><g:message code="default.show.label" args="[entityName]" /></h1>
    </g:if>
    <g:else>
    <h1><g:message code="default.create.label" args="[entityName]" /></h1>
    </g:else>
  </div>
  <div class="panel-body">
    <g:if test="${flash.formMessage}">
    <div class="alert alert-info alert-dismissable" role="status"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>${flash.formMessage}</div>
    </g:if>
    <form role="form">
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'nombres','has-error' )}">
        <label for="nombres" class="control-label">
          <g:message code="asistente.nombres.label" default="Nombre(s)" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese los nombre(s) del asistente" name="nombres" maxlength="30" value="${asistenteInstance?.nombres}"/>

        <g:hasErrors bean="${asistenteInstance}" field="nombres">
          <g:eachError bean="${asistenteInstance}" field="nombres">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'apellidos','has-error' )}">
        <label for="apellidos" class="control-label">
          <g:message code="asistente.apellidos.label" default="Apellidos" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese los apellidos del asistente" name="apellidos" maxlength="30" value="${asistenteInstance?.apellidos}"/>

        <g:hasErrors bean="${asistenteInstance}" field="apellidos">
          <g:eachError bean="${asistenteInstance}" field="apellidos">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'correoElectronico','has-error' )}">
        <label for="correoElectronico" class="control-label">
          <g:message code="asistente.correoElectronico.label" default="Correo Electronico" />
          
        </label>
        <g:field class="form-control" placeholder="Ingrese el correo electrónico del asistente" type="email" name="correoElectronico" maxlength="50" value="${asistenteInstance?.correoElectronico}"/>

        <g:hasErrors bean="${asistenteInstance}" field="correoElectronico">
          <g:eachError bean="${asistenteInstance}" field="correoElectronico">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'nivelAcademico','has-error' )}">
        <label for="nivelAcademico" class="control-label">
          <g:message code="asistente.nivelAcademico.label" default="Nivel Academico" />
          
        </label>
        <g:select class="form-control" name="nivelAcademico" from="${constancias.Asistente.constraints.nivelAcademico.inList}" value="${asistenteInstance?.nivelAcademico}" valueMessagePrefix="asistente.nivelAcademico" noSelection="['': '']"/>

        <g:hasErrors bean="${asistenteInstance}" field="nivelAcademico">
          <g:eachError bean="${asistenteInstance}" field="nivelAcademico">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'taller','has-error' )}">
        <label for="taller" class="control-label">
          <g:message code="asistente.taller.label" default="Taller" />
          
        </label>
        <!--<g:select class="form-control" id="taller" name="taller.id" from="${constancias.Taller.list()}" optionKey="id" value="${asistenteInstance?.taller?.id}" noSelection="['null': '']"/>-->
        <g:talleresRestantes asistente="${asistenteInstance}"/>

        <g:hasErrors bean="${asistenteInstance}" field="taller">
          <g:eachError bean="${asistenteInstance}" field="taller">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'constancia','has-error' )}">
        <label for="constancia" class="control-label">
          <g:message code="asistente.constancia.label" default="Constancia" />
          
        </label>
        <g:checkBox name="constancia" value="${asistenteInstance?.constancia}" />

        <g:hasErrors bean="${asistenteInstance}" field="constancia">
          <g:eachError bean="${asistenteInstance}" field="constancia">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:asistenteInstance, field:'asistencia','has-error' )}">
        <label for="asistencia" class="control-label">
          <g:message code="asistente.asistencia.label" default="Asistencia" />
          
        </label>
        <g:checkBox name="asistencia" value="${asistenteInstance?.asistencia}" />

        <g:hasErrors bean="${asistenteInstance}" field="asistencia">
          <g:eachError bean="${asistenteInstance}" field="asistencia">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${asistenteInstance?.id}" />
      <g:hiddenField name="version" value="${asistenteInstance?.version}" />
      <g:submitToRemote class="btn btn-primary" url="[action: 'update']" update="[success:'form', failure:'form']" name="update" value="${message(code: 'default.button.update.label', default: 'Update')}" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();" onSuccess="${remoteFunction(action:'list', update:'list', method:'GET')}"/>
      <g:field class="btn btn-default" type="reset" name="reset" value="${message(code: 'default.button.reset.label', default: 'Reset')}"/>
      <g:remoteLink class="btn btn-success" action="create" update="form" method="GET" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();"><g:message code="default.button.new.label" default="New"/></g:remoteLink>
      </g:if>
      <g:else>
      <g:submitToRemote class="btn btn-primary" url="[action: 'save']" update="[success:'form', failure:'form']" name="create" value="${message(code: 'default.button.create.label', default: 'Create')}" before="\$('form').find('.loading').show()" onComplete="\$('.loading').hide();" onSuccess="${remoteFunction(action:'list', update:'list', method:'GET')}"/>
      <g:field class="btn btn-default" type="reset" name="reset" value="${message(code: 'default.button.reset.label', default: 'Reset')}"/>
      </g:else>
      <span class="loading">
        <span class="glyphicon glyphicon-refresh spinner"/>
      </span>
    </form>
  </div>
</div>
