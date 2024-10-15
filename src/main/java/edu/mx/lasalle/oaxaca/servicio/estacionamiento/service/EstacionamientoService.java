package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EstacionamientoModel;

import java.util.List;
import org.springframework.stereotype.Service;

/**
 *
 * @author jonag
 */
@Service
public interface EstacionamientoService {
    public void registrarEstacionamiento(EstacionamientoModel estacionamientoModel);
    public List<EstacionamientoModel> obtenerEstacionamientos();
    public EstacionamientoModel getEstacionamiento(Long id);
    public void actualizarDatosEstacionamiento(EstacionamientoModel estacionamientoModel, Long id);
    public void borrarEstacionamiento(Long id);
    public void borrarTodosLosEstacionamientos();
}
