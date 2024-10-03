package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "clientes")
public class Cliente extends Usuario {

	/*
	 * @Id
	 * 
	 * @GeneratedValue(strategy = GenerationType.IDENTITY) private int idCliente; //
	 * Clave primaria en la tabla clientes
	 */

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

	public Cliente(String nombreEmpresa, String rutEmpresa, String telefonoEmpresa, String correoEmpresa,
			String direccionEmpresa, String comunaEmpresa) {
		super();

		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.comunaEmpresa = comunaEmpresa;
	}

	public Cliente(String nombreUsuario, String apellidoUsuario, String nickname, String contrasena, String runUsuario,
			String correoUsuario, String telefonoUsuario, String tipoUsuario, String nombreEmpresa, String rutEmpresa,
			String telefonoEmpresa, String correoEmpresa, String direccionEmpresa, String comunaEmpresa) {
		super(nombreUsuario, apellidoUsuario, nickname, contrasena, runUsuario, correoUsuario, telefonoUsuario,
				tipoUsuario);
		this.nombreEmpresa = nombreEmpresa;
		this.rutEmpresa = rutEmpresa;
		this.telefonoEmpresa = telefonoEmpresa;
		this.correoEmpresa = correoEmpresa;
		this.direccionEmpresa = direccionEmpresa;
		this.comunaEmpresa = comunaEmpresa;
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
