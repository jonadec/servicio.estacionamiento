package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.*;
import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
public class VehiculoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
    @SequenceGenerator(name = "vehiculo_seq", sequenceName = "vehiculo_seq", allocationSize = 1)
    private Long idVehiculo;

    private String placa;
    private String tipo;
    private String color;
    

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "conductor_id", referencedColumnName = "idPersona")
    @JsonManagedReference
    private PersonaModel conductor;

    // Getters y Setters

    public Long getIdVehiculo() {
        return idVehiculo;
    }

    public void setIdVehiculo(Long idVehiculo) {
        this.idVehiculo = idVehiculo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public PersonaModel getConductor() {
        return conductor;
    }

    public void setConductor(PersonaModel conductor) {
        this.conductor = conductor;
    }

    @Override
    public String toString() {
        return "VehiculoModel{" +
                "idVehiculo=" + idVehiculo +
                ", placa='" + placa + '\'' +
                ", tipo='" + tipo + '\'' +
                ", color='" + color + '\'' +
                ", conductor=" + conductor +
                '}';
    }
}
