package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "administrativos")  // Corregido a plural
public class Administrativo extends Usuario {

    private String areaAdministrativo;
    private String experienciaPrevia;

    public Administrativo() {
        super();
    }

    public Administrativo(String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
                          String telefonoUsuario, String tipoUsuario, String areaAdministrativo, String experienciaPrevia) {
        super(nombreUsuario, apellidoUsuario, runUsuario, correoUsuario, telefonoUsuario, tipoUsuario);
        this.areaAdministrativo = areaAdministrativo;
        this.experienciaPrevia = experienciaPrevia;
    }

    public String getAreaAdministrativo() {
        return areaAdministrativo;
    }

    public void setAreaAdministrativo(String areaAdministrativo) {
        this.areaAdministrativo = areaAdministrativo;
    }

    public String getExperienciaPrevia() {
        return experienciaPrevia;
    }

    public void setExperienciaPrevia(String experienciaPrevia) {
        this.experienciaPrevia = experienciaPrevia;
    }
}
