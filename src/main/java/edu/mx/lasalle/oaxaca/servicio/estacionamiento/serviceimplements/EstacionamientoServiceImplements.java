package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EstacionamientoModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.EstacionamientoRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.EstacionamientoService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */

@Service
public class EstacionamientoServiceImplements implements EstacionamientoService {
    @Autowired
    private EstacionamientoRepository estacionamientoRepository;

    @Override
    public void registrarEstacionamiento(EstacionamientoModel estacionamientoModel) {
        estacionamientoRepository.save(estacionamientoModel);
    }

    @Override
    public List<EstacionamientoModel> obtenerEstacionamientos() {
        return estacionamientoRepository.findAll();
    }

    @Override
    public EstacionamientoModel getEstacionamiento(Long id) {
        return estacionamientoRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarDatosEstacionamiento(EstacionamientoModel estacionamientoModel, Long id) {
        estacionamientoModel.setId(id);
        estacionamientoRepository.save(estacionamientoModel);
    }

    @Override
    public void borrarEstacionamiento(Long id) {
        estacionamientoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosEstacionamientos() {
        estacionamientoRepository.deleteAll();
    }

}

