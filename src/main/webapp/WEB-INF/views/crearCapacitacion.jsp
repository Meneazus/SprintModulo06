<%@ page import="java.util.List"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Capacitacion"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Nueva Capacitaci�n</title>
    <!-- Bootstrap CSS -->
    <link
        href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/res/css/estilo.css">
</head>
<body>

    <!-- Navbar o cualquier otra parte de tu p�gina -->
    <%@ include file='navbar.jsp'%>

    <div class="container mt-5">
        <div class="row justify-content-center">
            <div class="col-lg-6 col-md-8">
                <h2 class="text-center mb-4">Crear Nueva Capacitaci�n</h2>
                <p class="text-center">Utiliza el formulario a continuaci�n para
                    registrar una capacitaci�n para tu equipo. Aseg�rate de completar
                    todos los campos requeridos.</p>

                <!-- Mostrar mensajes de error o �xito -->
                <c:if test="${not empty error}">
                    <div class="alert alert-danger">${error}</div>
                </c:if>
                <c:if test="${not empty mensaje}">
                    <div class="alert alert-success">${mensaje}</div>
                </c:if>

                <!-- Formulario para crear la capacitaci�n -->
                <form action="${pageContext.request.contextPath}/capacitaciones" method="post">
                    <div class="mb-3">
                        <label for="nombreCapacitacion" class="form-label">Nombre de la Capacitaci�n</label>
                        <input type="text" class="form-control" id="nombreCapacitacion" name="nombreCapacitacion" value="${capacitacion.nombreCapacitacion}" required>
                        <div class="invalid-feedback">Por favor, ingresa el nombre de la capacitaci�n.</div>
                    </div>

                    <div class="mb-3">
                        <label for="detalleCapacitacion" class="form-label">Detalle de la Capacitaci�n</label>
                        <textarea class="form-control" id="detalleCapacitacion" name="detalleCapacitacion" rows="3" required>${capacitacion.detalleCapacitacion}</textarea>
                        <div class="invalid-feedback">Por favor, ingresa el detalle de la capacitaci�n.</div>
                    </div>

                    <div class="mb-3">
                        <label for="rutEmpresa" class="form-label">RUT de la Empresa</label>
                        <input type="text" class="form-control" id="rutEmpresa" name="rutEmpresa" value="${capacitacion.rutEmpresa}" required pattern="\d{7,8}-[kK\d]">
                        <div class="invalid-feedback">Por favor, ingresa un RUT v�lido.</div>
                    </div>

                    <!-- Bot�n de env�o -->
                    <div class="text-center">
                        <button type="submit" class="btn btn-outline-light">Crear</button>
                        <br>
                        <a href="${pageContext.request.contextPath}/capacitaciones" class="btn btn-outline-light">Ver Todas las Capacitaciones</a>
                    </div>
                </form>
            </div>

        </div>
    </div>

    <!-- Footer o cualquier otra parte de tu p�gina -->
    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

    <script>
        // Validaci�n personalizada o scripts adicionales si los necesitas
        // Ejemplo de validaci�n Bootstrap
        (function () {
            'use strict'

            // Fetch all the forms we want to apply custom Bootstrap validation styles to
            var forms = document.querySelectorAll('form')

            // Loop over them and prevent submission
            Array.prototype.slice.call(forms)
                .forEach(function (form) {
                    form.addEventListener('submit', function (event) {
                        if (!form.checkValidity()) {
                            event.preventDefault()
                            event.stopPropagation()
                        }

                        form.classList.add('was-validated')
                    }, false)
                })
        })()
    </script>
</body>
</html>
