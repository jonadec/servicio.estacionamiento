package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.*;
import java.util.List;

import com.fasterxml.jackson.annotation.JsonManagedReference;


@Entity
@Table(name = "estacionamiento")
public class EstacionamientoModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "estacionamiento_seq")
    @Column(name = "estacionamiento_id")
    private Long id;
    private String nombre;
    private String direccion;
    @OneToMany(mappedBy = "estacionamiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    @JsonManagedReference
    private List<EspacioModel> espacios;
    
    @OneToMany(mappedBy = "estacionamiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<TicketModel> tickets;

    
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }

    public List<EspacioModel> getEspacios() {
        return espacios;
    }

    public void setEspacios(List<EspacioModel> espacios) {
        this.espacios = espacios;
    }

    public List<TicketModel> getTickets() {
        return tickets;
    }

    public void setTickets(List<TicketModel> tickets) {
        this.tickets = tickets;
    }

    @Override
    public String toString() {
        return "EstacionamientoModel{" +
                "id=" + id +
                ", nombre='" + nombre + '\'' +
                ", direccion='" + direccion + '\'' +
                ", espacios=" + espacios +
                ", tickets=" + tickets +
                '}';
    }
}
