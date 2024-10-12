package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TarifaModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.TarifaService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 * Controlador para la entidad Tarifa
 */
@RestController
@RequestMapping("/api/v1/tarifa")
public class TarifaController {

    @Autowired
    private TarifaService tarifaService;

    // Registrar una nueva tarifa
    @PostMapping("/registro")
    public CustomResponse registrarTarifa(@RequestBody TarifaModel tarifaModel) {
        CustomResponse customResponse = new CustomResponse();
        tarifaService.registrarTarifa(tarifaModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("TARIFA REGISTRADA EXITOSAMENTE");
        return customResponse;
    }

    // Obtener todas las tarifas
    @GetMapping("/registros")
    public ResponseEntity<List<TarifaModel>> getAllTarifas() {
        List<TarifaModel> tarifas = tarifaService.obtenerTarifas();
        if (tarifas.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tarifas, HttpStatus.OK);
    }

    // Obtener una tarifa por ID
    @GetMapping("/{id}")
    public ResponseEntity<Object> getTarifa(@PathVariable Long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponse(HttpStatus.OK,
                        tarifaService.getTarifa(id),
                        "Tarifa obtenida exitosamente", 200
                )
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY,
                        null,
                        "ERROR: " + e.getMessage(), 422
                )
            );
        }
    }

    // Actualizar una tarifa existente
    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> actualizarTarifa(
            @RequestBody TarifaModel tarifaModel,
            @PathVariable(value = "id") Long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            if (tarifaService.getTarifa(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT,
                            "", "No se encontró tarifa con id= " + id,
                            204
                    )
                );
            }

            tarifaService.actualizarDatosTarifa(tarifaModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("TARIFA ACTUALIZADA EXITOSAMENTE");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).body(customResponse);
        }
    }

    // Eliminar una tarifa
    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> borrarTarifa(@PathVariable Long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            tarifaService.borrarTarifa(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("TARIFA ELIMINADA EXITOSAMENTE");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
