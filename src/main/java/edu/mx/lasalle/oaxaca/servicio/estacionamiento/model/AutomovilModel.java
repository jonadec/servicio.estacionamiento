package edu.mx.lasalle.oaxaca.servicio.estacionamiento.model;
import jakarta.persistence.DiscriminatorValue;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;
@Entity
@DiscriminatorValue("automovil")
@Table(name = "automovil")
public class AutomovilModel extends VehiculoModel {
    private int numeroPuertas;

    // Getters y Setters
    

    public int getNumeroPuertas() {
        return numeroPuertas;
    }

    public void setNumeroPuertas(int numeroPuertas) {
        this.numeroPuertas = numeroPuertas;
    }




    @Override
    public String toString() {
        return "AutomovilModel{" +
                "numeroPuertas=" + numeroPuertas +
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
        result = prime * result + numeroPuertas;
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
        AutomovilModel other = (AutomovilModel) obj;
        if (numeroPuertas != other.numeroPuertas)
            return false;
        return true;
    }

    
}
