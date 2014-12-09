<div class="panel panel-info">
	<div class="panel-heading">
    	<h1>Talleres <small><span class="cargar" style="display: none;"><span class="glyphicon glyphicon-refresh spinner"/></span></small></h1>
  	</div>
  	<div class="panel-body">
  		<div class="container">
    		<div class="list-group">
	    		<g:each var="i" in="${talleres}">
    					<g:remoteLink class="list-group-item" before="\$(this).find('.cargar').show()" onComplete="\$('.cargar').hide();" action="buscarAlumnosTaller"
    					params="[taller: i.id]" update="panel">
              ${i}
              <span class="badge"><g:totalAlumnosTaller taller="${i.id}" />
              </span>
            </g:remoteLink>
    			</g:each>
			</div>	
		</div>
  	</div>
</div>