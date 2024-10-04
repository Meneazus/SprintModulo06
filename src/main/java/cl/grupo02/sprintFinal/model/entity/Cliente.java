package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "clientes")
public class Cliente{

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer idCliente;

	@OneToOne
	@JoinColumn(name = "idUsuario")
	private Usuario usuario;

	private String nombreEmpresa;
	private String rutEmpresa;
	private String telefonoEmpresa;
	private String correoEmpresa;
	private String direccionEmpresa;
	private String comunaEmpresa;

	public Cliente() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Cliente(Integer idCliente, Usuario usuario, String nombreEmpresa, String rutEmpresa, String telefonoEmpresa,
			String correoEmpresa, String direccionEmpresa, String comunaEmpresa) {
		super();
		this.idCliente = idCliente;
		this.usuario = usuario;
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.comunaEmpresa = comunaEmpresa;
	}

	public Integer getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(Integer idCliente) {
		this.idCliente = idCliente;
	}

	public Usuario getUsuario() {
		return usuario;
	}

	public void setUsuario(Usuario usuario) {
		this.usuario = usuario;
	}

	public String getNombreEmpresa() {
		return nombreEmpresa;
	}

	public void setNombreEmpresa(String nombreEmpresa) {
		this.nombreEmpresa = nombreEmpresa;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getTelefonoEmpresa() {
		return telefonoEmpresa;
	}

	public void setTelefonoEmpresa(String telefonoEmpresa) {
		this.telefonoEmpresa = telefonoEmpresa;
	}

	public String getCorreoEmpresa() {
		return correoEmpresa;
	}

	public void setCorreoEmpresa(String correoEmpresa) {
		this.correoEmpresa = correoEmpresa;
	}

	public String getDireccionEmpresa() {
		return direccionEmpresa;
	}

	public void setDireccionEmpresa(String direccionEmpresa) {
		this.direccionEmpresa = direccionEmpresa;
	}

	public String getComunaEmpresa() {
		return comunaEmpresa;
	}

	public void setComunaEmpresa(String comunaEmpresa) {
		this.comunaEmpresa = comunaEmpresa;
	}

}
