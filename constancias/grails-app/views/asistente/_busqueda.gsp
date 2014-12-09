<div class="panel panel-info">
	<div class="panel-heading">
  		<h1>
  			Criterios de búsqueda
  			<small>
  				<span class="loader" style="display:none;">
	  				<span class="glyphicon glyphicon-refresh spinner"/>
				</span>
			</small>
  		</h1>
  	</div>
  	<div class="panel-body">
  		<g:formRemote role="form" 
  		              name="myForm" 
  		              update="resultados"
                    url="[controller: 'asistente', action:'buscarFolio']"
                    before="\$(document).find('.loader').show()" 
			      	      onComplete="\$('.loader').hide();">
  			<div class="form-group">
    			<label for="folio">Número de Folio</label>
    			<g:field name="folio" class="form-control" placeholder="Ingresa el número de folio" type="number" required="required"/>
  			</div>
  			<g:submitButton name="fol" value="Buscar" class="btn btn-success"/>
  		</g:formRemote>
  	</div>
</div>