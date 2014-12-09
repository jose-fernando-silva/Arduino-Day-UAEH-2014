<div class="col-md-12">
  <div class="panel panel-info">
    <div class="panel-heading">
      <h1>Bienvenido <strong><sec:loggedInUserInfo field="username"/></strong>
      	<small class="pull-right"><g:link controller='logout'>Cerrar sesión</g:link></small>
      </h1>
      
    </div>
    <div class="panel-body">
      <img class="img-responsive img-rounded" src="${resource(dir: 'images', file: 'im.png')}"/>
    </div>
  </div>
</div>
