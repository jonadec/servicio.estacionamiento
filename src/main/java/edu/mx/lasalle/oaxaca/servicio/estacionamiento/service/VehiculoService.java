package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.VehiculoModel;
import java.util.List;
import org.springframework.stereotype.Service;

/**
 * Servicio para gestionar operaciones relacionadas con los vehículos.
 */
@Service
public interface VehiculoService {
    
    // Registrar un nuevo vehículo
    public void registrarVehiculo(VehiculoModel vehiculoModel);
    
    // Obtener una lista de todos los vehículos registrados
    public List<VehiculoModel> obtenerVehiculos();
    
    // Obtener un vehículo por su ID
    public VehiculoModel getVehiculo(Long id);
    
    // Actualizar los datos de un vehículo
    public void actualizarVehiculo(VehiculoModel vehiculoModel, Long id);
    
    // Eliminar un vehículo por su ID
    public void borrarVehiculo(Long id);
    
    // Eliminar todos los vehículos registrados
    public void borrarTodosLosVehiculos();
}
