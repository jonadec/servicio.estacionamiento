package edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.VehiculoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface VehiculoRepository extends JpaRepository<VehiculoModel, Long> {
    public VehiculoModel findById(long idVehiculo);
}
