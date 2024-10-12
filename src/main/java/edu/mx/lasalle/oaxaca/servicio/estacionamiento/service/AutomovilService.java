package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.AutomovilModel;
import java.util.List;

/**
 * Interfaz para el servicio de Automovil
 */
public interface AutomovilService {
    void registrarAutomovil(AutomovilModel automovilModel);
    List<AutomovilModel> obtenerAutomoviles();
    AutomovilModel getAutomovil(long id);
    void actualizarDatosAutomovil(AutomovilModel automovilModel, long id);
    void borrarAutomovil(long id);
    void borrarTodosLosAutomoviles();
}
