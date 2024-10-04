<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <title>Navbar</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <!-- Tu archivo de estilos personalizado -->
    <link rel="stylesheet" type="text/css" href="<c:url value='/res/css/estilo.css'/>">
</head>
<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <!-- Marca de la aplicación -->
            <a class="navbar-brand" href="<c:url value='/'/>">Prevención Segura</a>
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
                        <a class="nav-link" aria-current="page" href="<c:url value='/'/>">Inicio</a>
                    </li>
                    
                    <!-- Capacitaciones Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Capacitaciones
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="<c:url value='/capacitaciones'/>">Listar Capacitaciones</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/capacitaciones/nueva'/>">Crear Capacitación</a></li>
                        </ul>
                    </li>

                    <!-- Visitas a Terreno Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Visitas a Terreno
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="<c:url value='/obtenerVisita'/>">Listar Visitas</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/crearVisita'/>">Crear Visita</a></li>
                        </ul>
                    </li>

                    <!-- Revisiones de Check List Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Revisiones de Check List
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="<c:url value='/listarRevisiones'/>">Listar Revisiones</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/crearRevision?idVisita=1'/>">Crear Revisión</a></li> <!-- Ajusta idVisita dinámicamente si es posible -->
                        </ul>
                    </li>

                    <!-- Usuarios Dropdown -->
                    <li class="nav-item dropdown">
                        <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">
                            Usuarios
                        </a>
                        <ul class="dropdown-menu">
                            <li><a class="dropdown-item" href="<c:url value='/usuarios'/>">Listar Usuarios</a></li>
                            <li><a class="dropdown-item" href="<c:url value='/usuarios/crear'/>">Crear Usuario</a></li>
                        </ul>
                    </li>
                    
                    <!-- Enlace directo a Contacto -->
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/contacto'/>">Contacto</a>
                    </li>
                    <!-- Botón de Login -->
                    <li class="nav-item">
                        <a class="nav-link" href="<c:url value='/login'/>">Login</a>
                    </li>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>
