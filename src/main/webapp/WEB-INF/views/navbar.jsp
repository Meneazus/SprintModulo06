<%@ page language="java" contentType="text/html; charset=UTF-8"	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
	<meta charset="UTF-8">
	<link rel="stylesheet" type="text/css" href="res/css/estilo.css">

</head>

<body>
	<nav class="navbar navbar-expand-lg navbar-dark bg-dark">
		<div class="container-fluid">

			<a class="navbar-brand" href="./">Prevención Segura</a>
			<button class="navbar-toggler" type="button" data-bs-toggle="collapse"
				data-bs-target="#navbarNav" aria-controls="navbarNav"
				aria-expanded="false" aria-label="Toggle navigation">
				<span class="navbar-toggler-icon"></span>
			
			
			
			</button>
			<div class="collapse navbar-collapse" id="navbarNav">
				<ul class="navbar-nav ms-auto">
					<li class="nav-item"><a class="nav-link" aria-current="page"
						href="./">Inicio</a></li>
					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownListar" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Listar</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownListar">
							<li><a class="dropdown-item" href="obtenerCapacitacion">Listar Capacitación</a></li>
							<li><a class="dropdown-item" href="listarUsuarios">Listar Usuarios</a></li>


						</ul>
					</li>

					<li class="nav-item"><a class="nav-link" href="contacto">Contacto</a></li>
				<li class="nav-item"><a class="nav-link" href="crearCapacitacion">Crear Capacitacion</a></li>
				<li class="nav-item"><a class="nav-link" href="crearUsuario">Crear Usuario</a></li>
				
<!-- 			
				<li class="nav-item"><a class="nav-link" href="crearCapacitacion">Crear Capacitacion</a></li>
 -->		
 		
<!-- 					<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownCrear" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Crear</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownCrear">
							<li><a class="dropdown-item" href="CrearCapacitacion">Crear Capacitación</a></li>
							<li><a class="dropdown-item" href="CrearUsuario">Crear Usuario</a></li>
						</ul>
					</li> -->
<!-- 					<li class="nav-item invisible-item">
    					<a class="nav-link" href="#">......</a>
					</li> -->
<!-- 				<li class="nav-item dropdown">
						<a class="nav-link dropdown-toggle" href="#" id="navbarDropdownListar" role="button"
							data-bs-toggle="dropdown" aria-expanded="false">Listar</a>
						<ul class="dropdown-menu" aria-labelledby="navbarDropdownListar">
							<li><a class="dropdown-item" href="obtenerCapacitacion">Listar Capacitación</a></li>
							<li><a class="dropdown-item" href="ListarUsuarios">Listar Usuarios</a></li>
						</ul>
					</li> -->
					<%
					if (session.getAttribute("SPRING_SECURITY_CONTEXT") != null) {
					%>
					<!-- Botón de Logout -->
					<li class="nav-item"><a class="nav-link" href="logout">Logout</a></li>
				
					<%
					} else {
					%>
					<li class="nav-item"><a class="nav-link" href="login">Login</a></li>
					<%
					}
					%> 
					

				</ul>
			</div>
		</div>
	</nav>

</body>
</html>
