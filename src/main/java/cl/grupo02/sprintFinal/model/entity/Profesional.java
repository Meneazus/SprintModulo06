package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Table(name = "profesionales")
public class Profesional{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idProfesional;

    // Clave foránea a Usuario
    @OneToOne
    @JoinColumn(name = "idUsuario")
    private Usuario usuario;

    private String tituloProfesional;
    private String fechaIngresoProfesional;

    // Constructores
    public Profesional() {
        super();
    }

    public Profesional(Integer idProfesional, Usuario usuario, String tituloProfesional, String fechaIngresoProfesional) {
        this.idProfesional = idProfesional;
        this.usuario = usuario;
        this.tituloProfesional = tituloProfesional;
        this.fechaIngresoProfesional = fechaIngresoProfesional;
    }

	public Integer getIdProfesional() {
		return idProfesional;
	}

	public void setIdProfesional(Integer idProfesional) {
		this.idProfesional = idProfesional;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
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

	public void setFechaIngresoProfesional(String string) {
		this.fechaIngresoProfesional = string;
	}

}
