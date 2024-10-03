<%@ page language="java" contentType="text/html; charset=UTF-8"
	pageEncoding="UTF-8"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Pago"%>
<%@ page import="java.util.ArrayList"%>
<%@ page import="java.util.List"%>
<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
<meta charset="UTF-8">
<meta name="viewport" content="width=device-width, initial-scale=1">
<title>Crear Pago</title>
<link
	href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css"
	rel="stylesheet">
<link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>

	<!-- Navbar o cualquier otra parte de tu página -->
	<%@ include file='navbar.jsp'%>
	<div class="container">
		<div class="form-container">
			<h2 class="form-title">Crear Pago</h2>
			<form action="/grupal08/crearPago" method="POST">
				<div class="mb-3">
					<label for="rutEmpresa" class="form-label">RUT de la
						Empresa</label> <select class="form-select" id="rutEmpresa"
						name="rutEmpresa" required>
						<option value="rutEmpresa">Seleccione una empresa...</option>
						<%
						List<Pago> pagos = (List<Pago>) request.getAttribute("pagos");
						if (pagos != null) {
							for (Pago p : pagos) {
						%>
						<option value="<%=p.getIdPago()%>"><%=p.getRutEmpresa()%></option>
						<%
						}
						}
						%>
					</select>
				</div>
				<div class="mb-3">
					<label for="monto" class="form-label">Monto del pago</label> <input
						type="number" class="form-control" id="monto" name="monto"
						placeholder="250000" required>
				</div>
				<div class="mb-3">
					<label for="fecha" class="form-label">Fecha del pago </label> <input
						type="date" class="form-control" id="fecha" name="fecha" required>
					<div class="mb-3">
						<label for="detallePago" class="form-label">Detalle del
							Pago</label>
						<textarea class="form-control" id="detallePago" name="detallePago"
							rows="3" required></textarea>
					</div>
					<div class="d-grid gap-2">
						<button type="submit" class="btn btn-outline-light">Crear
							Pago</button>
					</div>
				</div>
			</form>
		</div>
	</div>
</body>

<!-- Footer -->
<%@ include file='footer.jsp'%>
<!-- Bootstrap JS -->
<script
	src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</html>