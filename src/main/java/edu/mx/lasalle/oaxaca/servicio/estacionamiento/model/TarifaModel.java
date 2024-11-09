package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;

@Entity
@Table(name = "tarifa")
public class TarifaModel {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long idTarifa;
    private double costoHoraAutomovil;
    private double costoHoraMotocicleta;

    // Getters y Setters

    public Long getIdTarifa() {
        return idTarifa;
    }

    public void setIdTarifa(Long idTarifa) {
        this.idTarifa = idTarifa;
    }

    public double getCostoHoraAutomovil() {
        return costoHoraAutomovil;
    }

    public void setCostoHoraAutomovil(double costoHoraAutomovil) {
        this.costoHoraAutomovil = costoHoraAutomovil;
    }

    public double getCostoHoraMotocicleta() {
        return costoHoraMotocicleta;
    }

    public void setCostoHoraMotocicleta(double costoHoraMotocicleta) {
        this.costoHoraMotocicleta = costoHoraMotocicleta;
    }

    @Override
    public String toString() {
        return "TarifaModel{" +
                "idTarifa=" + idTarifa +
                ", costoHoraAutomovil=" + costoHoraAutomovil +
                ", costoHoraMotocicleta=" + costoHoraMotocicleta +
                '}';
    }
}
