package cl.grupo02.grupal071.model.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "pagos")
public class Pago {

	
	@Id
	//GeneratedValue se utiliza para hacer que el valor sea autoincremental en la BD
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idPago")
	private int idPago;
	
	
	private String rutEmpresa;
	private int monto;
	private String fecha;
	private String detallePago;
	
	
	public Pago() {
		super();
	}


	public Pago(int idPago, String rutEmpresa, int monto, String fecha, String detallePago) {
		super();
		this.idPago = idPago;
		this.rutEmpresa = rutEmpresa;
		this.monto = monto;
		this.fecha = fecha;
		this.detallePago = detallePago;
	}


	public int getIdPago() {
		return idPago;
	}


	public void setIdPago(int idPago) {
		this.idPago = idPago;
	}


	public String getRutEmpresa() {
		return rutEmpresa;
	}


	public void setRutEmpresa(String rutEmpresa) {
		this.rutEmpresa = rutEmpresa;
	}


	public int getMonto() {
		return monto;
	}


	public void setMonto(int monto) {
		this.monto = monto;
	}


	public String getFecha() {
		return fecha;
	}


	public void setFecha(String fecha) {
		this.fecha = fecha;
	}


	public String getDetallePago() {
		return detallePago;
	}


	public void setDetallePago(String detallePago) {
		this.detallePago = detallePago;
	}
		
}