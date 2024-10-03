package cl.grupo02.sprintFinal.model.entity;

import java.util.Map;

public class FormularioUsuario {

	private String nombreUsuario;
	private String apellidoUsuario;
	private String nickname;
	private String contrasena;
	private String runUsuario;
	private String correoUsuario;
	private String telefonoUsuario;
	private String tipoUsuario;

	private String areaAdministrativo;
	private String experienciaPrevia;

	private String nombreEmpresa;
	private String rutEmpresa;
	private String telefonoEmpresa;
	private String correoEmpresa;
	private String direccionEmpresa;
	private String comunaEmpresa;

	private String tituloProfesional;
	private String fechaIngresoProfesional;

	public FormularioUsuario() {
		super();
	}

	public FormularioUsuario(String nombreUsuario, String apellidoUsuario, String nickname, String contrasena,
			String runUsuario, String correoUsuario, String telefonoUsuario, String tipoUsuario,
			Map<String, String> camposAdicionales) {
		super();
		this.nombreUsuario = nombreUsuario;
		this.apellidoUsuario = apellidoUsuario;
		this.nickname = nickname;
		this.contrasena = contrasena;
		this.runUsuario = runUsuario;
		this.correoUsuario = correoUsuario;
		this.telefonoUsuario = telefonoUsuario;
		this.tipoUsuario = tipoUsuario;

		// Procesar los campos adicionales según el tipo de usuario
		if (tipoUsuario.equals("administrativo")) {
			this.areaAdministrativo = camposAdicionales.get("areaAdministrativo");
			this.experienciaPrevia = camposAdicionales.get("experienciaPrevia");
		} else if (tipoUsuario.equals("profesional")) {
			this.tituloProfesional = camposAdicionales.get("tituloProfesional");
			this.fechaIngresoProfesional = camposAdicionales.get("fechaIngresoProfesional");
		} else if (tipoUsuario.equals("cliente")) {
			this.nombreEmpresa = camposAdicionales.get("nombreEmpresa");
			this.rutEmpresa = camposAdicionales.get("rutEmpresa");
			this.telefonoEmpresa = camposAdicionales.get("telefonoEmpresa");
			this.correoEmpresa = camposAdicionales.get("correoEmpresa");
			this.direccionEmpresa = camposAdicionales.get("direccionEmpresa");
			this.comunaEmpresa = camposAdicionales.get("comunaEmpresa");

		}
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
