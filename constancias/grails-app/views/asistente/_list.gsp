<g:set var="entityName" value="${message(code: 'asistente.label', default: 'Asistente')}" />
<div class="panel panel-info">
  <div class="panel-heading">
    <h1>
      <g:message code="default.list.label" args="[entityName]" />
      <span class="loading">
        <small><span class="glyphicon glyphicon-refresh spinner"/></small>
      </span>
    </h1>
  </div>
  <div class="panel-body">
    <g:if test="${flash.listMessage}">
    <div class="alert alert-info alert-dismissable" role="status"><button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>${flash.listMessage}</div>
    </g:if>
    <div class="table-responsive">
      <table class="table table-striped">
        <thead>
          <tr>

            <util:remoteSortableColumn property="id" title="No. Folio" action="list" update="list" method="GET" params="${params}" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
            
            <util:remoteSortableColumn property="nombres" title="${message(code: 'asistente.nombres.label', default: 'Nombres')}" action="list" update="list" method="GET" params="${params}" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
            
            <util:remoteSortableColumn property="apellidos" title="${message(code: 'asistente.apellidos.label', default: 'Apellidos')}" action="list" update="list" method="GET" params="${params}" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
            
            <th><g:message code="default.options.label" default="Options" /></th>
          </tr>
        </thead>
        <tbody>
        <g:each in="${items}" status="i" var="asistenteInstance">
          <tr>
            <td>${fieldValue(bean: asistenteInstance, field: "id")}</td>

            <td>${fieldValue(bean: asistenteInstance, field: "nombres")}</td>
            
            <td>${fieldValue(bean: asistenteInstance, field: "apellidos")}</td>
            
            <td>
              <g:remoteLink action="edit" id="${asistenteInstance.id}" update="form" method="GET" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"><span class="label label-success"><span class="glyphicon glyphicon-eye-open"></span></span></g:remoteLink>
              <sec:ifAllGranted roles="ROLE_ADMIN">
              <g:remoteLink action="delete" id="${asistenteInstance.id}" update="content" before="if(confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}') == false) return false"><span class="label label-danger"><span class="glyphicon glyphicon-remove"></span></span></g:remoteLink>
            </sec:ifAllGranted>
            </td>
          </tr>
        </g:each>
        </tbody>
      </table>
    </div>
    <util:remotePaginate total="${total}" action="list" update="list" method="GET" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
  </div>
</div>