package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;

import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "motocicleta")
public class MotocicletaModel extends VehiculoModel {

    private boolean tieneCasco;

    // Getters y Setters

    public boolean isTieneCasco() {
        return tieneCasco;
    }

    public void setTieneCasco(boolean tieneCasco) {
        this.tieneCasco = tieneCasco;
    }

    @Override
    public String toString() {
        return "MotocicletaModel{" +
                "tieneCasco=" + tieneCasco +
                ", placa='" + getPlaca() + '\'' +
                ", tipo='" + getTipo() + '\'' +
                ", color='" + getColor() + '\'' +
                ", conductor=" + getConductor() +
                '}';
    }

    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + (tieneCasco ? 1231 : 1237);
        return result;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj)
            return true;
        if (obj == null)
            return false;
        if (getClass() != obj.getClass())
            return false;
        MotocicletaModel other = (MotocicletaModel) obj;
        if (tieneCasco != other.tieneCasco)
            return false;
        return true;
    }

    
}
