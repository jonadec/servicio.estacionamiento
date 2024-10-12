package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.PersonaModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.PersonaRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.PersonaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio para la gestión de personas.
 */
@Service
public class PersonaServiceImplements implements PersonaService {

    @Autowired
    private PersonaRepository personaRepository;

    @Override
    public void registrarPersona(PersonaModel personaModel) {
        personaRepository.save(personaModel);
    }

    @Override
    public List<PersonaModel> obtenerPersonas() {
        return personaRepository.findAll();
    }

    @Override
    public PersonaModel getPersona(Long id) {
        return personaRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarDatosPersona(PersonaModel personaModel, Long id) {
        if (personaRepository.existsById(id)) {
            personaModel.setIdPersona(id);
            personaRepository.save(personaModel);
        }
    }

    @Override
    public void borrarPersona(Long id) {
        if (personaRepository.existsById(id)) {
            personaRepository.deleteById(id);
        }
    }

    @Override
    public void borrarTodasLasPersonas() {
        personaRepository.deleteAll();
    }
}
