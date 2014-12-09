<div class="table-responsive">
	<table class="table table-striped">
		<thead>
			<tr>
				<th>Nombre(s)</th>
				<th>Apellidos</th>
			</tr>
		</thead>
		<tbody>
			<g:each in="${asistentes}" status="i" var="asistenteInstance">
		  		<tr>
					<td>${fieldValue(bean: asistenteInstance, field: "nombres")}</td>
					<td>${fieldValue(bean: asistenteInstance, field: "apellidos")}</td>
		  		</tr>
			</g:each>
		</tbody>
	</table>
</div>
