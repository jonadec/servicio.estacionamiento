package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.PersonaModel;
import java.util.List;
import org.springframework.stereotype.Service;

@Service
public interface PersonaService {
    
    // Registrar una nueva persona
    public void registrarPersona(PersonaModel personaModel);
    
    // Obtener una lista de todas las personas registradas
    public List<PersonaModel> obtenerPersonas();
    
    // Obtener una persona por su ID
    public PersonaModel getPersona(Long id);
    
    // Actualizar los datos de una persona
    public void actualizarDatosPersona(PersonaModel personaModel, Long id);
    
    // Eliminar una persona por su ID
    public void borrarPersona(Long id);
    
    // Eliminar todas las personas registradas
    public void borrarTodasLasPersonas();
}
