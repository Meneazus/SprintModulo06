package cl.grupo02.sprintFinal.model.entity;

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
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "idCapacitacion")
    private Integer idCapacitacion; // Cambiado de int a Integer

    private String rutEmpresa;
    private String nombreCapacitacion;
    private String detalleCapacitacion;

    // Constructor sin argumentos
    public Capacitacion() {
        super();
    }

    // Constructor con todos los campos (incluyendo id)
    public Capacitacion(Integer idCapacitacion, String rutEmpresa, String nombreCapacitacion,
                        String detalleCapacitacion) {
        super();
        this.idCapacitacion = idCapacitacion;
        this.rutEmpresa = rutEmpresa;
        this.nombreCapacitacion = nombreCapacitacion;
        this.detalleCapacitacion = detalleCapacitacion;
    }

    // Constructor sin idCapacitacion
    public Capacitacion(String rutEmpresa, String nombreCapacitacion, String detalleCapacitacion) {
        super();
        this.rutEmpresa = rutEmpresa;
        this.nombreCapacitacion = nombreCapacitacion;
        this.detalleCapacitacion = detalleCapacitacion;
    }

    // Getters y Setters
    public Integer getIdCapacitacion() {
        return idCapacitacion;
    }

    public void setIdCapacitacion(Integer idCapacitacion) {
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
