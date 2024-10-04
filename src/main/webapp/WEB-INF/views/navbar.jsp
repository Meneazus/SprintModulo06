<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Tu archivo de estilos personalizado -->
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/estilo.css">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <!-- Marca de la aplicación -->
            <a class="navbar-brand" href="${pageContext.request.contextPath}/">Prevención Segura</a>
            <!-- Botón para dispositivos móviles -->
            <button class="navbar-toggler" type="button"
                data-bs-toggle="collapse" data-bs-target="#navbarNav"
                aria-controls="navbarNav" aria-expanded="false"
                aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <!-- Enlaces de navegación -->
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <!-- Enlace siempre visible -->
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="${pageContext.request.contextPath}/">Inicio</a>
                    </li>
                    
                    <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Capacitaciones</a>
			          <ul class="dropdown-menu">
			            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/capacitaciones">Listar Capacitaciones</a></li>
			            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/capacitaciones/nueva">Crear Capacitación</a></li>
			          </ul>
			        </li>

                    <!-- Enlaces directos -->

                     <li class="nav-item dropdown">
			          <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Usuarios</a>
			          <ul class="dropdown-menu">
			            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuarios">Listar Usuarios</a></li>
			            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuarios/crear">Crear Usuario</a></li>
			            <li><a class="dropdown-item" href="${pageContext.request.contextPath}/usuarios">Editar Usuarios</a></li>
			          </ul>
			        </li>
                    
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/contacto">Contacto</a>
                    </li>
                    <!-- Botón de Login -->
                    <li class="nav-item">
                        <a class="nav-link" href="${pageContext.request.contextPath}/login">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>

    <!-- Contenido de la página -->
</body>
</html>
