<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>

<!DOCTYPE html>
<html lang="es">
<head>
<meta charset="UTF-8">
<title>Editar Usuario</title>
<!-- Bootstrap CSS para mejorar el estilo -->
<link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>

<div class="container">
    <h2 class="my-4">Editar Usuario</h2>

    <form action="${pageContext.request.contextPath}/actualizarUsuario" method="post">
    	<input type="hidden" name="idUsuario" value="${usuario.idUsuario}"/>

        <!-- Campos comunes para todos los tipos de usuario -->
        <div class="mb-3">
            <label for="nombreUsuario" class="form-label">Nombre:</label>
            <input type="text" id="nombreUsuario" name="nombreUsuario" class="form-control" value="${usuario.nombreUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="apellidoUsuario" class="form-label">Apellido:</label>
            <input type="text" id="apellidoUsuario" name="apellidoUsuario" class="form-control" value="${usuario.apellidoUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="correoUsuario" class="form-label">Correo:</label>
            <input type="email" id="correoUsuario" name="correoUsuario" class="form-control" value="${usuario.correoUsuario}" required>
        </div>

        <div class="mb-3">
            <label for="telefonoUsuario" class="form-label">Teléfono:</label>
            <input type="text" id="telefonoUsuario" name="telefonoUsuario" class="form-control" value="${usuario.telefonoUsuario}" required>
        </div>

        <!-- Campos adicionales específicos para Cliente -->
        <c:if test="${tipoUsuario == 'cliente'}">
            <h3>Datos de Empresa</h3>

            <div class="mb-3">
                <label for="nombreEmpresa" class="form-label">Nombre Empresa:</label>
                <input type="text" id="nombreEmpresa" name="nombreEmpresa" class="form-control" value="${usuario.nombreEmpresa}">
            </div>

            <div class="mb-3">
                <label for="rutEmpresa" class="form-label">RUT Empresa:</label>
                <input type="text" id="rutEmpresa" name="rutEmpresa" class="form-control" value="${usuario.rutEmpresa}">
            </div>
        </c:if>

        <!-- Campos adicionales específicos para Profesional -->
        <c:if test="${tipoUsuario == 'profesional'}">
            <h3>Datos Profesionales</h3>

            <div class="mb-3">
                <label for="tituloProfesional" class="form-label">Título Profesional:</label>
                <input type="text" id="tituloProfesional" name="tituloProfesional" class="form-control" value="${usuario.tituloProfesional}">
            </div>

            <div class="mb-3">
                <label for="fechaIngresoProfesional" class="form-label">Fecha de Ingreso:</label>
                <input type="date" id="fechaIngresoProfesional" name="fechaIngresoProfesional" class="form-control" value="${usuario.fechaIngresoProfesional}">
            </div>
        </c:if>

        <!-- Campos adicionales específicos para Administrativo -->
        <c:if test="${tipoUsuario == 'administrativo'}">
            <h3>Datos Administrativos</h3>

            <div class="mb-3">
                <label for="areaAdministrativo" class="form-label">Área:</label>
                <input type="text" id="areaAdministrativo" name="areaAdministrativo" class="form-control" value="${usuario.areaAdministrativo}">
            </div>

            <div class="mb-3">
                <label for="experienciaPrevia" class="form-label">Experiencia Previa:</label>
                <input type="text" id="experienciaPrevia" name="experienciaPrevia" class="form-control" value="${usuario.experienciaPrevia}">
            </div>
        </c:if>

        <!-- Botón para actualizar el usuario -->
        <input type="submit" value="Actualizar Usuario"/>
    </form>
</div>

<!-- Bootstrap JS -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>
