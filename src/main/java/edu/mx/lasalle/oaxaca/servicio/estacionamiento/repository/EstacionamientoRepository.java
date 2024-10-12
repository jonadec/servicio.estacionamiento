package edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EstacionamientoModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EstacionamientoRepository extends JpaRepository<EstacionamientoModel, Long> {
    public EstacionamientoModel findById(long id);
}
