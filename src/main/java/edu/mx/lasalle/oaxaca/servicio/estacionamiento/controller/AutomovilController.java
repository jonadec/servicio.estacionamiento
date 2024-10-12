package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.AutomovilModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.AutomovilService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para manejar las operaciones de Automovil
 */
@RestController
@RequestMapping("/api/v1/automovil")
public class AutomovilController {

    @Autowired
    private AutomovilService automovilService;

    @PostMapping("/registro")
    public CustomResponse registrarAutomovil(@RequestBody AutomovilModel automovilModel) {
        CustomResponse customResponse = new CustomResponse();
        automovilService.registrarAutomovil(automovilModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("AUTOMÓVIL REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<AutomovilModel>> getAllAutomoviles() {
        List<AutomovilModel> automoviles = automovilService.obtenerAutomoviles();
        if (automoviles.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(automoviles, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getAutomovil(@PathVariable long id) {
        try {
            AutomovilModel automovil = automovilService.getAutomovil(id);
            if (automovil == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "", "No se encontró el automóvil con id= " + id, 204)
                );
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, automovil, "Detalles del automóvil", 200)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e.getMessage(), 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateAutomovil(@RequestBody AutomovilModel automovilModel, @PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (automovilService.getAutomovil(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                        new CustomResponse(HttpStatus.NO_CONTENT, "", "No se encontró el automóvil con id= " + id, 204)
                );
            }
            automovilService.actualizarDatosAutomovil(automovilModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Actualización exitosa");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteAutomovil(@PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            automovilService.borrarAutomovil(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("BORRADO EXITOSO");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
