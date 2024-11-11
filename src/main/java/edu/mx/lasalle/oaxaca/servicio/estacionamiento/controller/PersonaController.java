package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.PersonaModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.PersonaService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/persona")
public class PersonaController {

    @Autowired
    private PersonaService personaService;

    @PostMapping("/registro")
    public CustomResponse registrarPersona(@RequestBody PersonaModel personaModel){
        CustomResponse customResponse = new CustomResponse();
        personaService.registrarPersona(personaModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("PERSONA REGISTRADA EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<PersonaModel>> getAllPersonas(){
        List<PersonaModel> personas = personaService.obtenerPersonas();
        if(personas.isEmpty()){
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(personas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getPersona(@PathVariable long id){
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK,
                            personaService.getPersona(id),
                            "Persona obtenida exitosamente", 200
                    )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                            null,
                            "ERROR: " + e, 422
                    )
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updatePersona(
            @RequestBody PersonaModel personaModel,
            @PathVariable(value = "id") long id){
        CustomResponse customResponse = new CustomResponse();

        try {
            if(personaService.getPersona(id) == null){
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT,
                        null, "No se encontró persona con id= " + id, 204)
                );
            }

            personaService.actualizarDatosPersona(personaModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Actualización exitosa");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deletePersona(@PathVariable long id){
        CustomResponse customResponse = new CustomResponse();
        try {
            personaService.borrarPersona(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Persona eliminada exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
