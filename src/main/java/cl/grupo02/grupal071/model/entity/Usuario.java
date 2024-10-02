package cl.grupo02.grupal071.model.entity;

import java.util.HashSet;
import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.persistence.JoinColumn;

@Entity
@Table(name = "usuarios")
public class Usuario {

	@Id
	// GeneratedValue se utiliza para hacer que el valor sea autoincremental en la
	// BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idUsuario")
	private int idUsuario;
	/* @Column(name = "nombreUsuario") */
	private String nombreUsuario;
	/* @Column(name = "apellidoUsuario") */
	private String apellidoUsuario;
	/* @Column(name = "nickname") */
	/* private String nickname; */
	/* @Column(name = "runUsuario") */
	private String runUsuario;
	/* @Column(name = "correoUsuario") */
	private String correoUsuario;
	/* @Column(name = "telefonoUsuario") */
	private String telefonoUsuario;
	/* @Column(name = "contrasena") */
	/* private String contrasena; */
	/* @Column(name = "tipoUsuario") */
	private String tipoUsuario;
	/* private String username; */

	/*
	 * private Cliente cliente; private Profesional profesional; private
	 * Administrativo administrativo;
	 */

	/*
	 * @ManyToMany(fetch = FetchType.EAGER)
	 * 
	 * @JoinTable(name = "usuariosroles", joinColumns = @JoinColumn(name =
	 * "usuarioid"), inverseJoinColumns = @JoinColumn(name = "rolid")) private
	 * Set<Rol> roles = new HashSet<>();
	 */

	public Usuario() {
		super();
	}

	public Usuario(int idUsuario, String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
			String telefonoUsuario, String tipoUsuario) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.runUsuario = runUsuario;
		this.correoUsuario = correoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;
	}

	public Usuario(String nombreUsuario, String apellidoUsuario, String runUsuario, String correoUsuario,
			String telefonoUsuario, String tipoUsuario) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.runUsuario = runUsuario;
		this.correoUsuario = correoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;
	}

	/*
	 * public Cliente getCliente() { return cliente; }
	 * 
	 * public void setCliente(Cliente cliente) { this.cliente = cliente; }
	 * 
	 * public Profesional getProfesional() { return profesional; }
	 * 
	 * public void setProfesional(Profesional profesional) { this.profesional =
	 * profesional; }
	 * 
	 * public Administrativo getAdministrativo() { return administrativo; }
	 * 
	 * public void setAdministrativo(Administrativo administrativo) {
	 * this.administrativo = administrativo; }
	 */

	public int getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(int idUsuario) {
		this.idUsuario = idUsuario;
	}

	public String getNombreUsuario() {
		return nombreUsuario;
	}

	public void setNombreUsuario(String nombreUsuario) {
		this.nombreUsuario = nombreUsuario;
	}

	public String getApellidoUsuario() {
		return apellidoUsuario;
	}

	public void setApellidoUsuario(String apellidoUsuario) {
		this.apellidoUsuario = apellidoUsuario;
	}

	public String getRunUsuario() {
		return runUsuario;
	}

	public void setRunUsuario(String runUsuario) {
		this.runUsuario = runUsuario;
	}

	public String getCorreoUsuario() {
		return correoUsuario;
	}

	public void setCorreoUsuario(String correoUsuario) {
		this.correoUsuario = correoUsuario;
	}

	public String getTelefonoUsuario() {
		return telefonoUsuario;
	}

	public void setTelefonoUsuario(String telefonoUsuario) {
		this.telefonoUsuario = telefonoUsuario;
	}

	public String getTipoUsuario() {
		return tipoUsuario;
	}

	public void setTipoUsuario(String tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}

}
