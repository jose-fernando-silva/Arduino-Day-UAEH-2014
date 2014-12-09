<g:formRemote   name="formAsistencia" 
				update="resultados"
				url="[controller: 'asistente', action:'tomarAsistencia']"
				before="\$(document).find('.cargar').show()" 
                onComplete="\$('.cargar').hide();">
	<div class="table-responsive">
		<table class="table table-bordered table-striped">
			<tr>
				<td>Número Folio</td>
				<td>${asistente.id}</td>
				<g:hiddenField name="folio" value="${asistente.id}"/>
			</tr>

			<tr>
				<td>Apellidos</td>
				<td>${asistente.apellidos}</td>
			</tr>

			<tr>
				<td>Nombre(s)</td>
				<td>${asistente.nombres}</td>
			</tr>

			<tr>
				<td>Taller</td>
				<td>
					<g:talleresRestantes asistente="${asistente}"/>
				</td>
			</tr>
			<tr>
				<td></td>
				<td>
					<g:submitButton name="tomarAsis" class="btn btn-success" value="Asistencia"/>
					<span class="cargar" style="display:none">
        				<span class="glyphicon glyphicon-refresh spinner"/>
    				</span>
				</td>			
			</tr>
		</table>
	</div>
</g:formRemote>
			