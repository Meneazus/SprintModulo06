package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "administrativos")
public class Administrativo{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idAdministrativo;

    // Clave foránea a Usuario
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String areaAdministrativo;
    private String experienciaPrevia;

    // Constructores
    public Administrativo() {
        super();
    }

    public Administrativo(Integer idAdministrativo, Usuario usuario, String areaAdministrativo, String experienciaPrevia) {
        this.idAdministrativo = idAdministrativo;
        this.usuario = usuario;
        this.areaAdministrativo = areaAdministrativo;
        this.experienciaPrevia = experienciaPrevia;
    }

	public Integer getIdAdministrativo() {
		return idAdministrativo;
	}

	public void setIdAdministrativo(Integer idAdministrativo) {
		this.idAdministrativo = idAdministrativo;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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
