package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.*;

import com.fasterxml.jackson.annotation.JsonBackReference;

@Entity
@Table(name = "espacios")
public class EspacioModel {

    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "espacio_seq")
    @SequenceGenerator(name = "espacio_seq", sequenceName = "espacio_seq", allocationSize = 1)
    private Long idEspacio;

    private String numero;
    private String tipo; 
    private boolean disponible;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "estacionamiento_id")
    @JsonBackReference
    private EstacionamientoModel estacionamiento;

    // Constructores

    public EspacioModel() {
    }

    public EspacioModel(String numero, String tipo, boolean disponible, EstacionamientoModel estacionamiento) {
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
        this.estacionamiento = estacionamiento;
    }

    // Getters y Setters

    public Long getId() {
        return idEspacio;
    }

    public void setId(Long id) {
        this.idEspacio = id;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public boolean isDisponible() {
        return disponible;
    }

    public void setDisponible(boolean disponible) {
        this.disponible = disponible;
    }

    public EstacionamientoModel getEstacionamiento() {
        return estacionamiento;
    }

    public void setEstacionamiento(EstacionamientoModel estacionamiento) {
        this.estacionamiento = estacionamiento;
    }

    @Override
    public String toString() {
        return "Espacio{" +
                "id=" + idEspacio +
                ", numero='" + numero + '\'' +
                ", tipo='" + tipo + '\'' +
                ", disponible=" + disponible +
                '}';
    }
}
