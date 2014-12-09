<div class="list-group">
    
    <g:remoteLink 
        class="list-group-item item-home active" 
        controller="home" 
        method="GET" 
        update="content" 
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-home').addClass('active');">
        <g:message code="default.home.label"/>
        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
    </g:remoteLink>
    

    <sec:ifAllGranted roles="ROLE_ADMIN">
    <!-- Talleres -->
    <g:remoteLink 
        class="list-group-item item-taller" 
        controller="taller" 
        update="content" 
        method="GET"
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-taller').addClass('active');">
        Talleres
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
    </g:remoteLink>
    </sec:ifAllGranted>

    <!-- Asistentes -->
    <g:remoteLink 
        class="list-group-item item-asistente" 
        controller="asistente" 
        update="content" 
        method="GET"
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-asistente').addClass('active');">
        Asistentes
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
    </g:remoteLink>


    <!-- Tomar Asistencia -->
    <g:remoteLink 
        class="list-group-item item-asistencia" 
        controller="asistente" 
        action="asistencia"
        update="content" 
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-asistencia').addClass('active');">
        Tomar Lista
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
    </g:remoteLink>

    <sec:ifAllGranted roles="ROLE_ADMIN">
    <!-- Lista -->
    <g:remoteLink 
        class="list-group-item item-lista" 
        controller="taller" 
        action="talleresCuenta"
        update="content" 
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-lista').addClass('active');">
        Alumnos en Taller
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
    </g:remoteLink>
    </sec:ifAllGranted>

    <!-- Constancias -->
    <sec:ifAllGranted roles="ROLE_ADMIN">
    <g:remoteLink 
        class="list-group-item item-constancias" 
        controller="asistente" 
        action="constancias"
        update="content" 
        method="GET"
        before="\$(this).find('.loading').show()" 
        onComplete="\$('.loading').hide();\$('.list-group-item').removeClass('active');\$('.item-constancias').addClass('active');">
        Constancias
        <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/></span>
    </g:remoteLink>
    </sec:ifAllGranted>
</div>
