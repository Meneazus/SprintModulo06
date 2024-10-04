package cl.grupo02.sprintFinal.model.entity;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.Size;
import java.io.Serializable;
import java.util.List;

@Entity
@Table(name = "visitas")
public class Visita implements Serializable {

	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "idVisita")
	private int idVisita;

	@ManyToOne(fetch = FetchType.LAZY)
	@JoinColumn(name = "idCliente", nullable = false) // Usar idCliente como FK
	private Cliente cliente;

	@NotBlank(message = "El día de la visita es obligatorio.")
	@Size(max = 20, message = "El día de la visita no debe exceder 20 caracteres.")
	@Column(name = "diaVisita", length = 20, nullable = false)
	private String diaVisita;

	@NotBlank(message = "La hora de la visita es obligatoria.")
	@Size(max = 20, message = "La hora de la visita no debe exceder 20 caracteres.")
	@Column(name = "horaVisita", length = 20, nullable = false)
	private String horaVisita;

	@NotBlank(message = "El lugar es obligatorio.")
	@Size(max = 50, message = "El lugar no debe exceder 50 caracteres.")
	@Column(name = "lugar", length = 50, nullable = false)
	private String lugar;

	@NotBlank(message = "El comentario es obligatorio.")
	@Size(max = 100, message = "El comentario no debe exceder 100 caracteres.")
	@Column(name = "comentario", nullable = false, length = 100)
	private String comentario;

	@OneToMany(mappedBy = "visita", cascade = CascadeType.ALL, orphanRemoval = true, fetch = FetchType.LAZY)
	private List<Revision> revisiones;

	public Visita() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Visita(int idVisita, Cliente cliente,
			@NotBlank(message = "El día de la visita es obligatorio.") @Size(max = 20, message = "El día de la visita no debe exceder 20 caracteres.") String diaVisita,
			@NotBlank(message = "La hora de la visita es obligatoria.") @Size(max = 20, message = "La hora de la visita no debe exceder 20 caracteres.") String horaVisita,
			@NotBlank(message = "El lugar es obligatorio.") @Size(max = 50, message = "El lugar no debe exceder 50 caracteres.") String lugar,
			@NotBlank(message = "El comentario es obligatorio.") @Size(max = 100, message = "El comentario no debe exceder 100 caracteres.") String comentario,
			List<Revision> revisiones) {
		super();
		this.idVisita = idVisita;
		this.cliente = cliente;
		this.diaVisita = diaVisita;
		this.horaVisita = horaVisita;
		this.lugar = lugar;
		this.comentario = comentario;
		this.revisiones = revisiones;
	}

	public int getIdVisita() {
		return idVisita;
	}

	public void setIdVisita(int idVisita) {
		this.idVisita = idVisita;
	}

	public Cliente getCliente() {
		return cliente;
	}

	public void setCliente(Cliente cliente) {
		this.cliente = cliente;
	}

	public String getDiaVisita() {
		return diaVisita;
	}

	public void setDiaVisita(String diaVisita) {
		this.diaVisita = diaVisita;
	}

	public String getHoraVisita() {
		return horaVisita;
	}

	public void setHoraVisita(String horaVisita) {
		this.horaVisita = horaVisita;
	}

	public String getLugar() {
		return lugar;
	}

	public void setLugar(String lugar) {
		this.lugar = lugar;
	}

	public String getComentario() {
		return comentario;
	}

	public void setComentario(String comentario) {
		this.comentario = comentario;
	}

	public List<Revision> getRevisiones() {
		return revisiones;
	}

	public void setRevisiones(List<Revision> revisiones) {
		this.revisiones = revisiones;
	}

	public static long getSerialversionuid() {
		return serialVersionUID;
	}

}
