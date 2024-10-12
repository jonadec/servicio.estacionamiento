package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EspacioModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface EspacioService {

    // Registrar un nuevo espacio
    public void registrarEspacio(EspacioModel espacioModel);
    
    // Obtener una lista de todos los espacios registrados
    public List<EspacioModel> obtenerEspacios();
    
    // Obtener un espacio por su ID
    public EspacioModel getEspacio(Long id);
    
    // Actualizar los datos de un espacio
    public void actualizarDatosEspacio(EspacioModel espacioModel, Long id);
    
    // Eliminar un espacio por su ID
    public void borrarEspacio(Long id);
    
    // Eliminar todos los espacios registrados
    public void borrarTodosLosEspacios();
}
