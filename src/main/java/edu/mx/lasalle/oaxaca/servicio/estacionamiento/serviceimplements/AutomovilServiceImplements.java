package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.AutomovilModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.AutomovilRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.AutomovilService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * Implementación del servicio de Automovil
 */
@Service
public class AutomovilServiceImplements implements AutomovilService {

    @Autowired
    private AutomovilRepository automovilRepository;

    @Override
    public void registrarAutomovil(AutomovilModel automovilModel) {
        automovilRepository.save(automovilModel);
    }

    @Override
    public List<AutomovilModel> obtenerAutomoviles() {
        return automovilRepository.findAll();
    }

    @Override
    public AutomovilModel getAutomovil(long id) {
        return automovilRepository.findById(id);
    }

    @Override
    public void actualizarDatosAutomovil(AutomovilModel automovilModel, long id) {
        automovilModel.setIdVehiculo(id); 
        automovilRepository.save(automovilModel);
    }

    @Override
    public void borrarAutomovil(long id) {
        automovilRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosAutomoviles() {
        automovilRepository.deleteAll();
    }
}
