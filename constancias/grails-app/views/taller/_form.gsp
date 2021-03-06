<g:set var="entityName" value="${message(code: 'taller.label', default: 'Taller')}" />
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
  
      <div class="form-group ${hasErrors(bean:tallerInstance, field:'nombre','has-error' )}">
        <label for="nombre" class="control-label">
          <g:message code="taller.nombre.label" default="Nombre" />
          
        </label>
        <g:textField class="form-control" placeholder="Ingrese el nombre del taller" name="nombre" maxlength="50" value="${tallerInstance?.nombre}"/>

        <g:hasErrors bean="${tallerInstance}" field="nombre">
          <g:eachError bean="${tallerInstance}" field="nombre">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <div class="form-group ${hasErrors(bean:tallerInstance, field:'numeroLugares','has-error' )}">
        <label for="numeroLugares" class="control-label">
          <g:message code="taller.numeroLugares.label" default="Numero Lugares" />
          <span class="required-indicator">*</span>
        </label>
        <g:field name="numeroLugares" class="form-control" placeholder="Ingresa el número de lugares" type="number" value="${tallerInstance?.numeroLugares}" required=""/>

        <g:hasErrors bean="${tallerInstance}" field="numeroLugares">
          <g:eachError bean="${tallerInstance}" field="numeroLugares">
          <span class="help-block"><g:message error="${it}"/></span>
          </g:eachError>
        </g:hasErrors>
      </div>
  
      <g:if test="${edit}">
      <g:hiddenField name="id" value="${tallerInstance?.id}" />
      <g:hiddenField name="version" value="${tallerInstance?.version}" />
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
