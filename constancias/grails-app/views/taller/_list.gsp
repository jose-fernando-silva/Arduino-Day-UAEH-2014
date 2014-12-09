<g:set var="entityName" value="${message(code: 'taller.label', default: 'Taller')}" />
<div class="panel panel-info">
  <div class="panel-heading">
	<h1>
	  Lista de Talleres
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
			
			<util:remoteSortableColumn property="nombre" title="${message(code: 'taller.nombre.label', default: 'Nombre')}" action="list" update="list" method="GET" params="${params}" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
			
			<util:remoteSortableColumn property="numeroLugares" title="${message(code: 'taller.numeroLugares.label', default: 'Numero Lugares')}" action="list" update="list" method="GET" params="${params}" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
			
			<th><g:message code="default.options.label" default="Options" /></th>
		  </tr>
		</thead>
		<tbody>
		<g:each in="${items}" status="i" var="tallerInstance">
		  <tr>
			
			<td>${fieldValue(bean: tallerInstance, field: "nombre")}</td>
			
			<td>${fieldValue(bean: tallerInstance, field: "numeroLugares")}</td>
			
			<td>
			  <g:remoteLink action="edit" id="${tallerInstance.id}" update="form" method="GET" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"><span class="label label-success"><span class="glyphicon glyphicon-eye-open"></span></span></g:remoteLink>
			  <g:remoteLink action="delete" id="${tallerInstance.id}" update="content" before="if(confirm('${message(code: 'default.button.delete.confirm.message', default: 'Are you sure?')}') == false) return false"><span class="label label-danger"><span class="glyphicon glyphicon-remove"></span></span></g:remoteLink>
			</td>
		  </tr>
		</g:each>
		</tbody>
	  </table>
	</div>
	<util:remotePaginate total="${total}" action="list" update="list" method="GET" before="\$('.panel-heading').find('.loading').show()" onComplete="\$('.loading').hide();"/>
  </div>
</div>
