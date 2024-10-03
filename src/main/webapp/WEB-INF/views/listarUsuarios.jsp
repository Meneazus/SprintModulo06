<%@ page import="java.util.List"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Usuario"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Cliente"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Profesional"%>
<%@ page import="cl.grupo02.sprintFinal.model.entity.Administrativo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Listado de Usuarios</title>
    <!-- Bootstrap CSS -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="res/css/estilo.css">
</head>
<body>
    <%@ include file='navbar.jsp'%>
    <div class="container-fluid">
        <br><br>
        <h2 class="mb-4">Listado de Usuarios</h2>

        <!-- Filtro para seleccionar el tipo de usuario -->
        <form method="get" class="mb-4">
            <label for="tipoUsuario" class="form-label">Filtrar por tipo de usuario:</label>
            <select id="tipoUsuario" name="tipoUsuario" class="form-select" onchange="this.form.submit()">
                <option value="" <%= (request.getParameter("tipoUsuario") == null) ? "selected" : "" %>>Seleccionar...</option>
                <option value="cliente" <%= "cliente".equals(request.getParameter("tipoUsuario")) ? "selected" : "" %>>Cliente</option>
                <option value="profesional" <%= "profesional".equals(request.getParameter("tipoUsuario")) ? "selected" : "" %>>Profesional</option>
                <option value="administrativo" <%= "administrativo".equals(request.getParameter("tipoUsuario")) ? "selected" : "" %>>Administrativo</option>
            </select>
        </form>

        <!-- Mostrar mensaje si no se selecciona un tipo de usuario -->
        <%
        String tipoUsuario = request.getParameter("tipoUsuario");
        if (tipoUsuario == null || tipoUsuario.isEmpty()) {
        %>
            <div class="alert alert-info">Debe seleccionar un tipo de usuario primero.</div>
        <%
        } else {
            List<Usuario> usuarios = (List<Usuario>) request.getAttribute("usuarios");
            if (usuarios != null && !usuarios.isEmpty()) {
        %>
        <!-- Tabla con los usuarios -->
        <table class="table table-bordered table-striped">
            <thead class="table-dark">
                <tr>
                    <th>Nombre</th>
                    <th>Apellido</th>
                    <th>RUN</th>
                    <th>Correo</th>
                    <th>Teléfono</th>
                    <th>Tipo Usuario</th>

                    <!-- Mostrar encabezados adicionales según el tipo de usuario -->
                    <%
                    if ("cliente".equals(tipoUsuario)) {
                    %>
                        <th>Nombre Empresa</th>
                        <th>Rut Empresa</th>
                        <th>Teléfono Empresa</th>
                        <th>Correo Empresa</th>
                        <th>Dirección Empresa</th>
                        <th>Comuna Empresa</th>
                    <%
                    } else if ("profesional".equals(tipoUsuario)) {
                    %>
                        <th>Título Profesional</th>
                        <th>Fecha Ingreso</th>
                    <%
                    } else if ("administrativo".equals(tipoUsuario)) {
                    %>
                        <th>Área Administrativo</th>
                        <th>Experiencia Previa</th>
                    <%
                    }
                    %>
                    <th>Acciones</th> <!-- Nueva columna para las acciones -->
                </tr>
            </thead>
            <tbody>
                <%
                for (Usuario u : usuarios) {
                    if (u.getTipoUsuario().equalsIgnoreCase(tipoUsuario)) {
                %>
                <tr style="font-size: 80%;">
                    <td><%=u.getNombreUsuario()%></td>
                    <td><%=u.getApellidoUsuario()%></td>
                    <td><%=u.getRunUsuario()%></td>
                    <td><%=u.getCorreoUsuario()%></td>
                    <td><%=u.getTelefonoUsuario()%></td>
                    <td style="text-transform: uppercase"><%=u.getTipoUsuario()%></td>

                    <!-- Mostrar datos adicionales según tipo de usuario -->
                    <%
                    if ("cliente".equals(u.getTipoUsuario()) && u instanceof Cliente) {
                    Cliente cliente = (Cliente) u;
                    %>
                        <td><%= cliente.getNombreEmpresa() %></td>
                        <td><%= cliente.getRutEmpresa() %></td>
                        <td><%= cliente.getTelefonoEmpresa() %></td>
                        <td><%= cliente.getCorreoEmpresa() %></td>
                        <td><%= cliente.getDireccionEmpresa() %></td>
                        <td><%= cliente.getComunaEmpresa() %></td>
                    <%
                    } else if ("profesional".equals(u.getTipoUsuario()) && u instanceof Profesional) {
                    Profesional profesional = (Profesional) u;
                    %>
                        <td><%= profesional.getTituloProfesional() %></td>
                        <td><%= profesional.getFechaIngresoProfesional() %></td>
                    <%
                    } else if ("administrativo".equals(u.getTipoUsuario()) && u instanceof Administrativo) {
                    Administrativo administrativo = (Administrativo) u;
                    %>
                        <td><%= administrativo.getAreaAdministrativo() %></td>
                        <td><%= administrativo.getExperienciaPrevia() %></td>
                    <%
                    }
                    %>

                    <!-- Columna de acciones -->
                    <td>
                        <!-- Formulario para modificar -->
                        <form action="editarUsuario" method="get" style="display:inline;">
                            <input type="hidden" name="id" value="<%= u.getIdUsuario() %>">
                            <button type="submit" class="btn btn-warning">Modificar</button>
                        </form>

                        <!-- Formulario para eliminar -->
                        <form action="eliminarUsuario" method="post" style="display:inline;" onsubmit="return confirm('¿Estás seguro de que deseas eliminar este usuario?');">
                            <input type="hidden" name="id" value="<%= u.getIdUsuario() %>">
                            <button type="submit" class="btn btn-danger">Eliminar</button>
                        </form>
                    </td>
                </tr>
                <%
                    }
                }
                %>
            </tbody>
        </table>
        <%
            } else {
        %>
            <div class="alert alert-warning">No hay usuarios disponibles para mostrar.</div>
        <%
            }
        }
        %>
    </div>

    <%@ include file='footer.jsp'%>

    <!-- Bootstrap JS -->
    <script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>
</body>
</html>
