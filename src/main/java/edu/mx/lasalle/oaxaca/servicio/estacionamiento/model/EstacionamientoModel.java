package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.*;
import java.util.List;


@Entity
@Table(name = "estacionamiento")
public class EstacionamientoModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    // @SequenceGenerator(name = "estacionamiento_seq", sequenceName = "estacionamiento_seq", allocationSize = 1)
    private Long id;

    private String nombre;
    private String direccion;

    @OneToMany(mappedBy = "estacionamiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    // @JsonManagedReference
    private List<EspacioModel> espacios;

    @OneToMany(mappedBy = "estacionamiento", cascade = CascadeType.ALL, fetch = FetchType.LAZY, orphanRemoval = true)
    // @JsonManagedReference
    private List<TicketModel> tickets;

    // Constructores

    public EstacionamientoModel() {
    }

    public EstacionamientoModel(String nombre, String direccion) {
        this.nombre = nombre;
        this.direccion = direccion;
    }

    public EstacionamientoModel(String nombre, String direccion, List<EspacioModel> espacios, List<TicketModel> tickets) {
        this.nombre = nombre;
        this.direccion = direccion;
        this.espacios = espacios;
        this.tickets = tickets;
    }

    // Getters y Setters

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
