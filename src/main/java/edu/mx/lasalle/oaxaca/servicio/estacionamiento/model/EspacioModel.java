package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import com.fasterxml.jackson.annotation.JsonBackReference;

import jakarta.persistence.*;



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

    @ManyToOne
    @JoinColumn(name = "estacionamiento_id")
    @JsonBackReference
    private EstacionamientoModel estacionamiento;

    // Constructores

    public EspacioModel() {
    }

    

    // Getters y Setters

    public EspacioModel(Long idEspacio, String numero, String tipo, boolean disponible,
            EstacionamientoModel estacionamiento) {
        this.idEspacio = idEspacio;
        this.numero = numero;
        this.tipo = tipo;
        this.disponible = disponible;
        this.estacionamiento = estacionamiento;
    }



    public Long getIdEspacio() {
        return idEspacio;
    }
    public void setIdEspacio(Long idEspacio) {
        this.idEspacio = idEspacio;
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
