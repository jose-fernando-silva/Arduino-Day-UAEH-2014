<div id="list" class="col-lg-3">
	<div class="panel panel-info">
		<div class="panel-heading">
  			<h3>Información de constancias</h3>
  		</div>
  		<div class="panel-body">
	  		<table class="table table-responsive table-bordered table-bordered table-striped">
  				<tr>
  					<td><strong>Total de asistentes</strong></td>
  					<td>${totalAsistentes}</td>
  				</tr>
  				<tr>
  					<td><strong>Total de constancias enviadas</strong></td>
  					<td>${constanciasEnviadas}</td>
  				</tr>
  			</table>
  		</div>
	</div>
</div>
<div id="form" class="col-lg-3">
	<div class="panel panel-info">
		<div class="panel-heading">
  			<h3>
  				Mandar Constancias
  				<small>
  					<span class="loader" style="display:none;">
	  					<span class="glyphicon glyphicon-refresh spinner"/>
					</span>
				</small>
  			</h3>
  		</div>
  		<div class="panel-body">
        <g:if test="${flash.message}">
          <div class='alert alert-info alert-dismissable'>
            <button type="button" class="close" data-dismiss="alert" aria-hidden="true">&times;</button>
            ${flash.message}
          </div>
        </g:if>

        
	  		<g:formRemote   
	  			name="formMandarConstancias" 
				update="content"
				url="[controller: 'asistente', action:'mandarMensaje']"
				before="\$(document).find('.loader').show()" 
                onComplete="\$('.loader').hide();">
                	<div class="form-group">
    					<label for="cantidadConstanciasAEnviar">Número de constancias a enviar: </label>
  						<g:field class="form-control" type="number" name="cantidadConstanciasAEnviar" value="${totalAsistentes - constanciasEnviadas}"/>
  					</div>
  					<g:if test="${(totalAsistentes - constanciasEnviadas) == 0}">
  						<g:submitButton class="btn btn-info" name="Enviar" value="Enviar" disabled="disabled"/>
  					</g:if>
  					<g:else>
  						<g:submitButton class="btn btn-info" name="Enviar" value="Enviar"/>
  					</g:else>
			</g:formRemote>
  		</div>
	</div>
</div>
<div id="form" class="col-lg-6">
	<div class="panel panel-info">
		<div class="panel-heading">
  			<h3>Alumnos sin constancia</h3>
  	</div>
  	<div class="panel-body">
      <g:render template="/taller/listaAlumnoTaller" model="[asistentes: asistentesSinConstancia]" />
	 	</div>
	</div>
</div>