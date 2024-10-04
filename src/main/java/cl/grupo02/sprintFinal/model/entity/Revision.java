package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;

@Entity
@Table(name = "revisiones")
public class Revision implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idRevision")
    private int idRevision;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "idVisita", nullable = false)
    private Visita visita;

    @NotBlank(message = "El nombre de la revisión es obligatorio.")
    @Size(max = 50, message = "El nombre de la revisión no debe exceder 50 caracteres.")
    @Column(name = "nombreRevision", length = 50, nullable = false)
    private String nombreRevision;

    @NotBlank(message = "El detalle de la revisión es obligatorio.")
    @Size(max = 500, message = "El detalle de la revisión no debe exceder 500 caracteres.")
    @Column(name = "detalleRevision", length = 500, nullable = false)
    private String detalleRevision;

    @NotBlank(message = "El estado de la revisión es obligatorio.")
    @Size(max = 20, message = "El estado de la revisión no debe exceder 20 caracteres.")
    @Column(name = "estadoRevision", length = 20, nullable = false)
    private String estadoRevision;

	public Revision() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Revision(int idRevision, Visita visita,
			@NotBlank(message = "El nombre de la revisión es obligatorio.") @Size(max = 50, message = "El nombre de la revisión no debe exceder 50 caracteres.") String nombreRevision,
			@NotBlank(message = "El detalle de la revisión es obligatorio.") @Size(max = 500, message = "El detalle de la revisión no debe exceder 500 caracteres.") String detalleRevision,
			@NotBlank(message = "El estado de la revisión es obligatorio.") @Size(max = 20, message = "El estado de la revisión no debe exceder 20 caracteres.") String estadoRevision) {
		super();
		this.idRevision = idRevision;
		this.visita = visita;
		this.nombreRevision = nombreRevision;
		this.detalleRevision = detalleRevision;
		this.estadoRevision = estadoRevision;
	}

	public int getIdRevision() {
		return idRevision;
	}

	public void setIdRevision(int idRevision) {
		this.idRevision = idRevision;
	}

	public Visita getVisita() {
		return visita;
	}

	public void setVisita(Visita visita) {
		this.visita = visita;
	}

	public String getNombreRevision() {
		return nombreRevision;
	}

	public void setNombreRevision(String nombreRevision) {
		this.nombreRevision = nombreRevision;
	}

	public String getDetalleRevision() {
		return detalleRevision;
	}

	public void setDetalleRevision(String detalleRevision) {
		this.detalleRevision = detalleRevision;
	}

	public String getEstadoRevision() {
		return estadoRevision;
	}

	public void setEstadoRevision(String estadoRevision) {
		this.estadoRevision = estadoRevision;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

    
}
