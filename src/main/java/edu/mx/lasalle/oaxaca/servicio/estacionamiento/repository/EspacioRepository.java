package edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EspacioModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EspacioRepository extends JpaRepository<EspacioModel, Long> {
    public EspacioModel findById(long id);
}
