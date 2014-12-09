<!DOCTYPE html>
<html lang="es">
	<head>
		<meta charset="UTF-8">
		<meta name="viewport" content="width=device-width, initial-scale=1.0">
		<title>Iniciar sesión</title>
		<link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'bootstrap.min.css')}" type="text/css" media="screen">
    	<link rel="stylesheet" href="${resource(plugin:'optimus', dir: 'css', file: 'main.css')}" type="text/css">
</head>

<body>
	<div>
   		<g:render template="/header"/>
    </div>

	<div class="container-fluid">
		<div class="row">
			<div class=" col-xs-12 col-sm-offset-2 col-sm-8 col-md-offset-3 col-md-6 col-lg-offset-4 col-lg-4">
				<div class="panel panel-info">
  					<div class="panel-heading"><h1>Iniciar sesión</h1></div>
  					<div class="panel-body">
  						<g:if test='${flash.message}'>
  							<div class="alert alert-danger">
								${flash.message}
							</div>
						</g:if>
  						
						<form action='${postUrl}' method='POST' id='loginForm' autocomplete='off' role="form">
							<div class="form-group">
    							<label for="username">Nombre de usuario: </label>
    							<input type="text" class="form-control" id="username" name="j_username" placeholder="Ingrese su nombre de usuario">
  							</div>

  							<div class="form-group">
    							<label for="password">Contraseña</label>
    							<input type="password" class="form-control" name='j_password' id="password" placeholder="Ingrese contraseña">
  							</div>
							<input type='submit' id="submit" value='Iniciar' class="btn btn-success"/>
						</form>
  					</div><!-- Fin body panel-->
				</div>
			</div>
		</div>
	</div>

	<script src="${resource(dir: 'js', file: 'jquery.js')}"></script>
    <script src="${resource(dir: 'js', file: 'bootstrap.min.js')}"></script>
</body>
</html>
