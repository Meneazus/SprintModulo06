<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/fmt" prefix="fmt" %>
<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>Lista de Revisiones</title>
    <link rel="stylesheet" href="<c:url value='/res/css/estilo.css'/>">
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
</head>
<body>
    <!-- Incluir el Navbar -->
    <jsp:include page="navbar.jsp" />

    <div class="container mt-4">
        <h1>Lista de Revisiones de Check List</h1>
        <a href="<c:url value='/crearRevision?idVisita=1'/>" class="btn btn-primary mb-3">Crear Nueva Revisi�n</a> <!-- Ajusta el idVisita seg�n corresponda -->
        <table class="table table-bordered table-striped">
            <thead>
                <tr>
                    <th>ID Revisi�n</th>
                    <th>ID Visita</th>
                    <th>Nombre de Revisi�n</th>
                    <th>Detalle</th>
                    <th>Estado</th>
                    <th>Acciones</th>
                </tr>
            </thead>
            <tbody>
                <c:forEach var="revision" items="${revisiones}">
                    <tr>
                        <td>${revision.idRevision}</td>
                        <td>${revision.visita.idVisita}</td>
                        <td>${revision.nombreRevision}</td>
                        <td>${revision.detalleRevision}</td>
                        <td>${revision.estadoRevision}</td>
                        <td>
                            <!-- Agrega acciones como editar o eliminar si es necesario -->
                        </td>
                    </tr>
                </c:forEach>
            </tbody>
        </table>
    </div>

    <!-- Bootstrap JS y dependencias -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
