package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.MotocicletaModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.MotocicletaService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/motocicleta")
public class MotocicletaController {

    @Autowired
    private MotocicletaService motocicletaService;

    @PostMapping("/registro")
    public CustomResponse registrarMotocicleta(@RequestBody MotocicletaModel motocicletaModel) {
        CustomResponse customResponse = new CustomResponse();
        motocicletaService.registrarMotocicleta(motocicletaModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("MOTOCICLETA REGISTRADA EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<MotocicletaModel>> getAllMotocicletas() {
        List<MotocicletaModel> motocicletas = motocicletaService.obtenerMotocicletas();
        if (motocicletas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(motocicletas, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getMotocicleta(@PathVariable long id) {
        try {
            MotocicletaModel motocicleta = motocicletaService.getMotocicleta(id);
            if (motocicleta != null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, motocicleta, "Motocicleta encontrada", 200)
                );
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new CustomResponse(HttpStatus.NOT_FOUND, null, "Motocicleta no encontrada", 404)
                );
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e, 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateMotocicleta(@RequestBody MotocicletaModel motocicletaModel, @PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            MotocicletaModel motocicletaExistente = motocicletaService.getMotocicleta(id);
            if (motocicletaExistente == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, "", "No se encontró motocicleta con el id= " + id, 204)
                );
            }
            motocicletaService.actualizarDatosMotocicleta(motocicletaModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Motocicleta actualizada con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteMotocicleta(@PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            motocicletaService.borrarMotocicleta(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Motocicleta eliminada con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
