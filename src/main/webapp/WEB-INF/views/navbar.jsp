<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ page import="org.springframework.security.core.Authentication"%>
<%@ page import="org.springframework.security.core.context.SecurityContextHolder"%>
<%@ page import="org.springframework.security.core.GrantedAuthority"%>
<%@ page import="java.util.HashSet"%>
<%@ page import="java.util.Set"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <title>Navbar</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="<c:url value='/res/css/estilo.css'/>">
</head>

<%
Authentication auth = SecurityContextHolder.getContext().getAuthentication();
Set<String> roles = new HashSet<>();
if (auth != null && auth.isAuthenticated()) {
    for (GrantedAuthority authority : auth.getAuthorities()) {
        roles.add(authority.getAuthority());
    }
}
boolean isCliente = roles.contains("CLIENTE");
boolean isAdministrativo = roles.contains("ADMINISTRATIVO");
boolean isProfesional = roles.contains("PROFESIONAL");
%>

<body>
    <nav class="navbar navbar-expand-lg navbar-dark bg-dark">
        <div class="container-fluid">
            <a class="navbar-brand" href="<c:url value='/'/>">Prevención Segura</a>
            <button class="navbar-toggler" type="button" data-bs-toggle="collapse" data-bs-target="#navbarNav" aria-controls="navbarNav" aria-expanded="false" aria-label="Toggle navigation">
                <span class="navbar-toggler-icon"></span>
            </button>
            <div class="collapse navbar-collapse" id="navbarNav">
                <ul class="navbar-nav ms-auto">
                    <li class="nav-item">
                        <a class="nav-link" aria-current="page" href="<c:url value='/'/>">Inicio</a>
                    </li>
                    <c:if test="${isCliente}">
                        <li class="nav-item">
                            <a class="nav-link" href="<c:url value='/contacto'/>">Contacto</a>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Capacitaciones</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="<c:url value='/capacitaciones'/>">Listar Capacitaciones</a></li>
                                <li><a class="dropdown-item" href="<c:url value='/capacitaciones/nueva'/>">Crear Capacitación</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${isAdministrativo}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Usuarios</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="<c:url value='/usuarios'/>">Listar Usuarios</a></li>
                                <li><a class="dropdown-item" href="<c:url value='/usuarios/crear'/>">Crear Usuario</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Pagos</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="crearPago">Crear Pagos</a></li>
                                <li><a class="dropdown-item" href="listarPagos">Listar Pagos</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:if test="${isProfesional}">
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Visitas a Terreno</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="<c:url value='/obtenerVisita'/>">Listar Visitas</a></li>
                                <li><a class="dropdown-item" href="<c:url value='/crearVisita'/>">Crear Visita</a></li>
                            </ul>
                        </li>
                        <li class="nav-item dropdown">
                            <a class="nav-link dropdown-toggle" href="#" role="button" data-bs-toggle="dropdown" aria-expanded="false">Revisiones de Check List</a>
                            <ul class="dropdown-menu">
                                <li><a class="dropdown-item" href="<c:url value='/listarRevisiones'/>">Listar Revisiones</a></li>
                            </ul>
                        </li>
                    </c:if>
                    <c:choose>
                        <c:when test="${not empty sessionScope['SPRING_SECURITY_CONTEXT']}">
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/logout'/>">Logout</a>
                            </li>
                        </c:when>
                        <c:otherwise>
                            <li class="nav-item">
                                <a class="nav-link" href="<c:url value='/login'/>">Login</a>
                            </li>
                        </c:otherwise>
                    </c:choose>
                </ul>
            </div>
        </div>
    </nav>
</body>
</html>
