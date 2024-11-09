package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import jakarta.persistence.*;

@Entity
@Table(name = "Vehiculo")
@Inheritance(strategy = InheritanceType.JOINED)
@DiscriminatorColumn(name = "dtype", discriminatorType = DiscriminatorType.STRING)
public class VehiculoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "vehiculo_seq")
    @SequenceGenerator(name = "vehiculo_seq", sequenceName = "vehiculo_seq", allocationSize = 1)
    private Long idVehiculo;
    private String placa;
    private String tipo;
    private String modelo;
    private String color;

    @OneToOne(mappedBy = "vehiculoModel",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private PersonaModel conductor;

    @OneToOne
    @JoinColumn(name = "idTicket")
    @JsonBackReference
    private TicketModel ticketModel;

    public VehiculoModel(Long idVehiculo, String placa, String tipo, String color,String modelo, PersonaModel conductor) {
        this.idVehiculo = idVehiculo;
        this.placa = placa;
        this.tipo = tipo;
        this.color = color;
        this.conductor = conductor;
        this.modelo = modelo;
    }
    public VehiculoModel() {
    }

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
    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
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
