package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.VehiculoModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.VehiculoRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.VehiculoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

/**
 * Implementación del servicio para gestionar vehículos.
 */
@Service
public class VehiculoServiceImplements implements VehiculoService {

    @Autowired
    private VehiculoRepository vehiculoRepository;

    @Override
    public void registrarVehiculo(VehiculoModel vehiculoModel) {
        vehiculoRepository.save(vehiculoModel);
    }

    @Override
    public List<VehiculoModel> obtenerVehiculos() {
        return vehiculoRepository.findAll();
    }

    @Override
    public VehiculoModel getVehiculo(Long id) {
        Optional<VehiculoModel> vehiculo = vehiculoRepository.findById(id);
        if (vehiculo.isPresent()) {
            return vehiculo.get();
        }
        return null;  
    }

    @Override
    public void actualizarVehiculo(VehiculoModel vehiculoModel, Long idVehiculo) {
        VehiculoModel vehiculoExistente = getVehiculo(idVehiculo);
        if (vehiculoExistente != null) {
            vehiculoModel.setIdVehiculo(idVehiculo);  
            vehiculoRepository.save(vehiculoModel);
        }
        
    }

    @Override
    public void borrarVehiculo(Long id) {
        vehiculoRepository.deleteById(id);
    }

    @Override
    public void borrarTodosLosVehiculos() {
        vehiculoRepository.deleteAll();
    }
}
