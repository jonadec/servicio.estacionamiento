package edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.MotocicletaModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MotocicletaRepository extends JpaRepository<MotocicletaModel, Long> {
    public MotocicletaModel findById(long id);
}
