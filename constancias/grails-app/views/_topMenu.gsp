<nav class="navbar navbar-default" role="navigation">
  <div class="navbar-header">
    <button type="button" class="navbar-toggle" data-toggle="collapse" data-target=".navbar-ex1-collapse">
      <span class="sr-only">Toggle navigation</span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
      <span class="icon-bar"></span>
    </button>
    <a class="navbar-brand" href="#">ARDUINO DAY 2014 - UAEH</a>
  </div>
  <div class="collapse navbar-collapse navbar-ex1-collapse">
    <ul class="nav navbar-nav">
      
      <li class="item-home active">
        <g:remoteLink 
            controller="home" 
            method="GET" 
            update="content" 
            before="\$(this).find('.loading').show()" 
            onComplete="\$('.loading').hide();
            \$('.navbar-nav li').removeClass('active');
            \$('.item-home').addClass('active');">
            <g:message code="default.home.label"/>
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
        </g:remoteLink>
      </li>
      <li class="item-taller">
        <g:remoteLink 
            controller="taller" 
            update="content" 
            method="GET"
            before="\$(this).find('.loading').show()" 
            onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-taller').addClass('active');">
            Talleres
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
        </g:remoteLink>
      </li>
      <li class="item-asistente">
        <!-- Asistentes -->
        <g:remoteLink 
            controller="asistente" 
            update="content" 
            method="GET"
            before="\$(this).find('.loading').show()" 
            onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-asistente').addClass('active');">
            Asistentes
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
        </g:remoteLink>
      </li>
      <li class="item-asistencia">
        <!-- Tomar Asistencia -->
        <g:remoteLink 
            controller="asistente" 
            action="asistencia"
            update="content" 
            before="\$(this).find('.loading').show()" 
            onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-asistencia').addClass('active');">
            Tomar Lista
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
        </g:remoteLink>
      </li>
      <li class="item-lista">
        <!-- Lista -->
        <g:remoteLink 
            controller="taller" 
            action="talleresCuenta"
            update="content" 
            before="\$(this).find('.loading').show()" 
            onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-lista').addClass('active');">
            Alumnos en Taller
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
        </g:remoteLink>
      </li>
      <li class="item-constancias">
        <g:remoteLink 
            controller="asistente" 
            action="constancias"
            update="content" 
            method="GET"
            before="\$(this).find('.loading').show()" 
            onComplete="\$('.loading').hide();\$('.navbar-nav li').removeClass('active');\$('.item-constancias').addClass('active');">
            Constancias
            <span class="loading"><span class="glyphicon glyphicon-refresh spinner"/>            </span>
        </g:remoteLink>
      </li>
    </ul>
  </div>
</nav>
 