<%@ page import="java.util.List"%>

<%@ page import="cl.grupo02.sprintFinal.model.entity.Capacitacion"%>

<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>


<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1.0">
<title>Crear Nueva Capacitación</title>
<!-- Bootstrap CSS -->
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>

	<!-- Navbar o cualquier otra parte de tu página -->
	<%@ include file='navbar.jsp'%>

	<div class="container mt-5">
		<div class="row justify-content-center">
			<div class="col-lg-6 col-md-8">
				<h2 class="text-center mb-4">Crear Nueva Capacitación</h2>
				<p class="text-center">Utiliza el formulario a continuación para
					registrar una capacitación para tu equipo. Asegúrate de completar
					todos los campos requeridos.</p>

				<!-- Formulario para crear la capacitación -->
				<form action="crearCapacitacion" method="post">
					<div class="mb-3">
						<label for="nombreCapacitacion" class="form-label">Nombre
							de la Capacitación</label> <input type="text" class="form-control"
							id="nombreCapacitacion" name="nombreCapacitacion" required>
					</div>

					<div class="mb-3">
						<label for="detalleCapacitacion" class="form-label">Detalle
							de la Capacitación</label>
						<textarea class="form-control" id="detalleCapacitacion"
							name="detalleCapacitacion" rows="3" required></textarea>
					</div>

					<div class="mb-3">
						<label for="rutEmpresa" class="form-label">RUT de la
							Empresa</label> <input type="number" class="form-control" id="rutEmpresa"
							name="rutEmpresa" required min="0" step="1">
					</div>

<%-- 												<option value="">Seleccione una empresa...</option>
                        <%
                            // Aquí es donde iteras sobre las empresas sin JSTL
                            List<Cliente> empresas = (List<Cliente>) request.getAttribute("empresas");
                            if (empresas != null) {
                                for (Cliente empresa : empresas) {
                        %>
                        <option value="<%= empresa.getRutEmpresa() %>"><%= empresa.getNombreEmpresa() %></option>
                        <%
                                }
                            }
                        %>
						</select> --%>
					<div class="text-center">
						<button type="submit" class="btn btn-outline-light">Crear</button>
					</div>
				</form>
			</div>
				<div class=text-center>
					<a href="obtenerCapacitacion" class="btn btn-outline-light">Obtener
						capacitaciones</a>
				</div>

			<!-- Mensaje de resultado -->
			<c:if test="${not empty mensaje}">
				<div class="alert alert-info">${mensaje}</div>
			</c:if>
		</div>
	</div>


	<!-- Footer o cualquier otra parte de tu página -->
	<%@ include file='footer.jsp'%>

	<!-- Bootstrap JS -->
	<script
		src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

</body>
</html>


