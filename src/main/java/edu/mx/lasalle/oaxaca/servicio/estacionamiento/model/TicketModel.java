package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;

import com.fasterxml.jackson.annotation.JsonManagedReference;

@Entity
@Table(name = "ticket")
public class TicketModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "ticket_seq")
    @SequenceGenerator(name = "ticket_seq", sequenceName = "ticket_seq", allocationSize = 1)
    private Long idTicket;
    private LocalDateTime entrada;
    private LocalDateTime salida;
    @Column(name = "costo_total")
    private Double costoTotal;

    

    @OneToOne(mappedBy = "ticketModel", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private VehiculoModel vehiculo;

    @ManyToOne
    @JoinColumn(name="idEspacio")
    private EspacioModel espacio;

    @ManyToOne
    @JoinColumn(name ="idTarifa")
    private TarifaModel tarifa;

    @ManyToOne 
    @JoinColumn(name = "estacionamiento_id") 
    private EstacionamientoModel estacionamiento;
    public Double getCostoTotal() {
        return costoTotal;
    }

    public void setCostoTotal(Double costoTotal) {
        this.costoTotal = costoTotal;
}

    public Long getIdTicket() {
        return idTicket;
    }

    public void setIdTicket(Long idTicket) {
        this.idTicket = idTicket;
    }

    public LocalDateTime getEntrada() {
        return entrada;
    }

    public void setEntrada(LocalDateTime entrada) {
        this.entrada = entrada;
    }

    public LocalDateTime getSalida() {
        return salida;
    }

    public void setSalida(LocalDateTime salida) {
        this.salida = salida;
    }

    public VehiculoModel getVehiculo() {
        return vehiculo;
    }

    public void setVehiculo(VehiculoModel vehiculo) {
        this.vehiculo = vehiculo;
    }

    public EspacioModel getEspacio() {
        return espacio;
    }

    public void setEspacio(EspacioModel espacio) {
        this.espacio = espacio;
    }

    public TarifaModel getTarifa() {
        return tarifa;
    }

    public void setTarifa(TarifaModel tarifa) {
        this.tarifa = tarifa;
    }
    


    @Override
    public String toString() {
        return "TicketModel{" +
                "idTicket=" + idTicket +
                ", entrada=" + entrada +
                ", salida=" + salida +
                ", vehiculo=" + vehiculo +
                ", espacio=" + espacio +
                ", tarifa=" + tarifa +
                ", costoTotal=" + costoTotal +
                '}';
    }
}
