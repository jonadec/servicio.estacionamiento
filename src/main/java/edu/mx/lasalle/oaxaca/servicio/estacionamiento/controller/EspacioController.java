package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EspacioModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.EspacioService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/espacios")
public class EspacioController {

    @Autowired
    private EspacioService espacioService;

    // Registrar un nuevo espacio
    @PostMapping("/registro")
    public CustomResponse registrarEspacio(@RequestBody EspacioModel espacioModel) {
        CustomResponse customResponse = new CustomResponse();
        espacioService.registrarEspacio(espacioModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("ESPACIO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    // Obtener todos los espacios
    @GetMapping("/registros")
    public ResponseEntity<List<EspacioModel>> getAllEspacios() {
        List<EspacioModel> espacios = espacioService.obtenerEspacios();
        if (espacios.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(espacios, HttpStatus.OK);
    }

    // Obtener un espacio por su ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getEspacio(@PathVariable long id) {
        try {
            EspacioModel espacio = espacioService.getEspacio(id);
            if (espacio != null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, espacio, "Espacio encontrado", 200)
                );
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new CustomResponse(HttpStatus.NOT_FOUND, null, "Espacio no encontrado", 404)
                );
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e, 422)
            );
        }
    }

    // Actualizar un espacio existente
    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateEspacio(@RequestBody EspacioModel espacioModel, @PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            EspacioModel espacioExistente = espacioService.getEspacio(id);
            if (espacioExistente == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, "", "No se encontró espacio con el id= " + id, 204)
                );
            }
            espacioService.actualizarDatosEspacio(espacioModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Espacio actualizado con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    // Eliminar un espacio por su ID
    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteEspacio(@PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            espacioService.borrarEspacio(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Espacio eliminado con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
