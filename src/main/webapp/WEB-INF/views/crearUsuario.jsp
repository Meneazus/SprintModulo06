<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>

<!DOCTYPE html>
<html lang="es" data-bs-theme="dark">
<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1.0">
    <title>Crear Usuario</title>
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/css/bootstrap.min.css" rel="stylesheet">
    <link rel="stylesheet" type="text/css" href="${pageContext.request.contextPath}/css/style.css">
    <style>
        .form-container {
            max-width: 600px;
            margin: 25px auto;
            padding: 20px;
            border-radius: 10px;
            box-shadow: 0 0 15px rgba(0, 0, 0, 0.2);
        }
        .form-title {
            text-align: center;
            margin-bottom: 10px;
        }
        .form-label {
            color: #ffffff;
        }

    </style>
</head>
<body>

<%@ include file='navbar.jsp'%>

<div class="container">
    <div class="form-container">
        <h2 class="form-title">Crear Usuario</h2>
        <form action="/grupal08/crearUsuario" method="POST">
            <div class="mb-3">
                <label for="nombreUsuario" class="form-label">Nombre</label>
                <input type="text" class="form-control" id="nombreUsuario" name="nombreUsuario" oninput="generarNickname()" required>
            </div>
            <div class="mb-3">
                <label for="apellidoUsuario" class="form-label">Apellido</label>
                <input type="text" class="form-control" id="apellidoUsuario" name="apellidoUsuario" oninput="generarNickname()" required>
            </div>
            
            <div class="mb-3">
                <label for="nickname" class="form-label">Nombre de Usuario</label>
                <input type="text" class="form-control" id="nickname" name="nickname" readonly>
            </div>
            
            <div class="mb-3">
                <label for="runUsuario" class="form-label">Run Usuario</label>
                <input type="text" class="form-control" id="runUsuario" name="runUsuario" required>
            </div>
            
            <div class="mb-3">
                <label for="correoUsuario" class="form-label">Email</label>
                <input type="email" class="form-control" id="correoUsuario" name="correoUsuario" required>
            </div>
            
            <div class="mb-3">
                <label for="telefonoUsuario" class="form-label">Teléfono</label>
                <input type="text" class="form-control" id="telefonoUsuario" name="telefonoUsuario" required>
            </div>
            
            <div class="mb-3">
                <label for="contrasena" class="form-label">Contraseña</label>
                <input type="password" class="form-control" id="contrasena" name="contrasena" required>
            </div>
            
            <div class="mb-3">
                <label for="tipoUsuario" class="form-label">Tipo de Usuario</label>
                <select class="form-select" id="tipoUsuario" name="tipoUsuario" required>
                    <option value="admin">Admin</option>
                    <option value="cliente">Cliente</option>
                    <option value="profesional">Profesional</option>
                    <option value="administrativo">Administrativo</option>
                </select>
            </div>
            <div class="d-grid gap-2">
                <button type="submit" class="btn btn-outline-light btn-lg px-5">Crear Usuario</button>
            </div>
        </form>
    </div>
</div>

<script src="https://cdn.jsdelivr.net/npm/bootstrap@5.3.0/dist/js/bootstrap.bundle.min.js"></script>

<script>
    function generarNickname() {
        var nombre = document.getElementById('nombreUsuario').value;
        var apellido = document.getElementById('apellidoUsuario').value;

        if (nombre && apellido) {
            var nombreUsuario = nombre.charAt(0).toLowerCase() + "_" + apellido.toLowerCase();
            document.getElementById('nickname').value = nombreUsuario;
        }
    }
</script>

</body>
</html>
