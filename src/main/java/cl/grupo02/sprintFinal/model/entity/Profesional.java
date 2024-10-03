package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "profesionales")
public class Profesional extends Usuario {

    private String tituloProfesional;
    private String fechaIngresoProfesional;

    public Profesional() {
        super();
    }

    public Profesional(String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
            String telefonoUsuario, String tipoUsuario, String tituloProfesional, String fechaIngresoProfesional) {
        super(nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario);
        this.tituloProfesional = tituloProfesional;
        this.fechaIngresoProfesional = fechaIngresoProfesional;
    }

    public String getTituloProfesional() {
        return tituloProfesional;
    }

    public void setTituloProfesional(String tituloProfesional) {
        this.tituloProfesional = tituloProfesional;
    }

    public String getFechaIngresoProfesional() {
        return fechaIngresoProfesional;
    }

    public void setFechaIngresoProfesional(String fechaIngresoProfesional) {
        this.fechaIngresoProfesional = fechaIngresoProfesional;
    }
}
