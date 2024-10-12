package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.MotocicletaModel;
import java.util.List;

import org.springframework.stereotype.Service;

@Service
public interface MotocicletaService {
    
    // Método para registrar una nueva motocicleta
    MotocicletaModel registrarMotocicleta(MotocicletaModel motocicletaModel);

    // Método para obtener todas las motocicletas registradas
    List<MotocicletaModel> obtenerMotocicletas();

    // Método para obtener una motocicleta específica por su ID
    MotocicletaModel getMotocicleta(long id);

    // Método para actualizar los datos de una motocicleta
    void actualizarDatosMotocicleta(MotocicletaModel motocicletaModel, long id);

    // Método para eliminar una motocicleta por su ID
    void borrarMotocicleta(long id);
}
