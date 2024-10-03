    function generarNickname() {
        var nombre = document.getElementById('nombreUsuario').value;
        var apellido = document.getElementById('apellidoUsuario').value;

        if (nombre && apellido) {
            var nombreUsuario = nombre.charAt(0).toLowerCase() + "_" + apellido.toLowerCase();
            document.getElementById('nickname').value = nombreUsuario;
        }
    }