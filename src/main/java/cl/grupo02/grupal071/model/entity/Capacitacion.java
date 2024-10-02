package cl.grupo02.grupal071.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "capacitaciones")
public class Capacitacion {
	
	@Id
	//GeneratedValue se utiliza para hacer que el valor sea autoincremental en la BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idCapacitacion")
	private int idCapacitacion;
	
	
	private String rutEmpresa;
	private String nombreCapacitacion;
	private String detalleCapacitacion;

	public Capacitacion() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Capacitacion(int idCapacitacion, String rutEmpresa, String nombreCapacitacion,
			String detalleCapacitacion) {
		super();
		this.idCapacitacion = idCapacitacion;
		this.rutEmpresa = rutEmpresa;
		this.nombreCapacitacion = nombreCapacitacion;
		this.detalleCapacitacion = detalleCapacitacion;
	}

	public int getIdCapacitacion() {
		return idCapacitacion;
	}

	public void setIdCapacitacion(int idCapacitacion) {
		this.idCapacitacion = idCapacitacion;
	}

	public String getRutEmpresa() {
		return rutEmpresa;
	}

	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}

	public String getNombreCapacitacion() {
		return nombreCapacitacion;
	}

	public void setNombreCapacitacion(String nombreCapacitacion) {
		this.nombreCapacitacion = nombreCapacitacion;
	}

	public String getDetalleCapacitacion() {
		return detalleCapacitacion;
	}

	public void setDetalleCapacitacion(String detalleCapacitacion) {
		this.detalleCapacitacion = detalleCapacitacion;
	}

}
