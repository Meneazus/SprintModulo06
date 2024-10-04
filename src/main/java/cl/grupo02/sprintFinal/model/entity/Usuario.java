package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;

@Entity
@Table(name = "usuarios")
public class Usuario{

	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer idUsuario;

    private String nombreUsuario;
    private String apellidoUsuario;
    private String nickname;
    private String contrasena;
    private String runUsuario;
    private String correoUsuario;
    private String telefonoUsuario;
    private String tipoUsuario;

    // Relaciones uno a uno con las entidades hijas
    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Cliente cliente;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Profesional profesional;

    @OneToOne(mappedBy = "usuario", cascade = CascadeType.ALL)
    private Administrativo administrativo;

	public Usuario() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Usuario(Integer idUsuario, String nombreUsuario, String apellidoUsuario, String nickname, String contrasena,
			String runUsuario, String correoUsuario, String telefonoUsuario, String tipoUsuario, Cliente cliente,
			Profesional profesional, Administrativo administrativo) {
		super();
		this.idUsuario = idUsuario;
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.nickname = nickname;
		this.contrasena = contrasena;
		this.runUsuario = runUsuario;
		this.correoUsuario = correoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;
		this.cliente = cliente;
		this.profesional = profesional;
		this.administrativo = administrativo;
	}

	public Integer getIdUsuario() {
		return idUsuario;
	}

	public void setIdUsuario(Integer idUsuario) {
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

	public String getNickname() {
		return nickname;
	}

	public void setNickname(String nickname) {
		this.nickname = nickname;
	}

	public String getContrasena() {
		return contrasena;
	}

	public void setContrasena(String contrasena) {
		this.contrasena = contrasena;
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

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public Profesional getProfesional() {
		return profesional;
	}

	public void setProfesional(Profesional profesional) {
		this.profesional = profesional;
	}

	public Administrativo getAdministrativo() {
		return administrativo;
	}

	public void setAdministrativo(Administrativo administrativo) {
		this.administrativo = administrativo;
	}
  
}
