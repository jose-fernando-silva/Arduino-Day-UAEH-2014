<g:set var="entityName" value="${message(code: 'prueba.label', default: 'Prueba')}" />
<div class="panel panel-default">
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
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'nombres','has-error' )}">
        <label for="nombres" class="control-label">
          <g:message code="prueba.nombres.label" default="Nombres" />
          
        </label>
        <g:textField class="form-control" placeholder="Enter Nombres" name="nombres" maxlength="30" value="${pruebaInstance?.nombres}"/>

        <g:hasErrors bean="${pruebaInstance}" field="nombres">
          <g:eachError bean="${pruebaInstance}" field="nombres">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'apellidos','has-error' )}">
        <label for="apellidos" class="control-label">
          <g:message code="prueba.apellidos.label" default="Apellidos" />
          
        </label>
        <g:textField class="form-control" placeholder="Enter Apellidos" name="apellidos" maxlength="30" value="${pruebaInstance?.apellidos}"/>

        <g:hasErrors bean="${pruebaInstance}" field="apellidos">
          <g:eachError bean="${pruebaInstance}" field="apellidos">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'correoElectronico','has-error' )}">
        <label for="correoElectronico" class="control-label">
          <g:message code="prueba.correoElectronico.label" default="Correo Electronico" />
          
        </label>
        <g:field class="form-control" placeholder="Enter Correo Electronico" type="email" name="correoElectronico" maxlength="50" value="${pruebaInstance?.correoElectronico}"/>

        <g:hasErrors bean="${pruebaInstance}" field="correoElectronico">
          <g:eachError bean="${pruebaInstance}" field="correoElectronico">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'nivelAcademico','has-error' )}">
        <label for="nivelAcademico" class="control-label">
          <g:message code="prueba.nivelAcademico.label" default="Nivel Academico" />
          
        </label>
        <g:select class="form-control" name="nivelAcademico" from="${constancias.Prueba.constraints.nivelAcademico.inList}" value="${pruebaInstance?.nivelAcademico}" valueMessagePrefix="prueba.nivelAcademico" noSelection="['': '']"/>

        <g:hasErrors bean="${pruebaInstance}" field="nivelAcademico">
          <g:eachError bean="${pruebaInstance}" field="nivelAcademico">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'taller','has-error' )}">
        <label for="taller" class="control-label">
          <g:message code="prueba.taller.label" default="Taller" />
          
        </label>
        <g:select class="form-control" id="taller" name="taller.id" from="${constancias.Taller.list()}" optionKey="id" value="${pruebaInstance?.taller?.id}" noSelection="['null': '']"/>

        <g:hasErrors bean="${pruebaInstance}" field="taller">
          <g:eachError bean="${pruebaInstance}" field="taller">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'constancia','has-error' )}">
        <label for="constancia" class="control-label">
          <g:message code="prueba.constancia.label" default="Constancia" />
          
        </label>
        <g:checkBox name="constancia" value="${pruebaInstance?.constancia}" />

        <g:hasErrors bean="${pruebaInstance}" field="constancia">
          <g:eachError bean="${pruebaInstance}" field="constancia">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:pruebaInstance, field:'asistencia','has-error' )}">
        <label for="asistencia" class="control-label">
          <g:message code="prueba.asistencia.label" default="Asistencia" />
          
        </label>
        <g:checkBox name="asistencia" value="${pruebaInstance?.asistencia}" />

        <g:hasErrors bean="${pruebaInstance}" field="asistencia">
          <g:eachError bean="${pruebaInstance}" field="asistencia">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${pruebaInstance?.id}" />
      <g:hiddenField name="version" value="${pruebaInstance?.version}" />
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
