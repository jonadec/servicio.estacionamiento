package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EstacionamientoModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.EstacionamientoService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

/**
 *
 * @author jonag
 */

@RestController
@RequestMapping("/api/v1/estacionamiento")
@CrossOrigin(origins = "*")
public class EstacionamientoController {
    @Autowired
    private EstacionamientoService estacionamientoService;

    @PostMapping("/registro")
    public CustomResponse registrarEstacionamiento(@RequestBody EstacionamientoModel estacionamientoModel) {
        CustomResponse customResponse = new CustomResponse();
        estacionamientoService.registrarEstacionamiento(estacionamientoModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("ESTACIONAMIENTO REGISTRADO EXITOSAMENTE");
        return customResponse;
            }



    @GetMapping("/registros")
    public ResponseEntity<List<EstacionamientoModel>> getAllEstacionamientos() {
        List<EstacionamientoModel> estacionamientos = estacionamientoService.obtenerEstacionamientos();
        if (estacionamientos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(estacionamientos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getEstacionamiento(@PathVariable long id) {
        try {
            return ResponseEntity.status(HttpStatus.OK).body(
                new CustomResponse(HttpStatus.OK,
                        estacionamientoService.getEstacionamiento(id),
                        "Show all matches", 200
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
    public ResponseEntity<Object> updateEstacionamiento(
            @RequestBody EstacionamientoModel estacionamientoModel,
            @PathVariable(value = "id") long id) {
        ResponseEntity<Object> responseEntity = null;
        CustomResponse customResponse = new CustomResponse();

        try {
            if (estacionamientoService.getEstacionamiento(id) == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT,
                            "", "This action can’t execute, not found with id= " + id,
                            204
                    )
                );
            }

            estacionamientoService.actualizarDatosEstacionamiento(estacionamientoModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Update success");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);

        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteEstacionamiento(@PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            estacionamientoService.borrarEstacionamiento(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("DELETE SUCCESS");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY)
                    .body(customResponse);
        }
    }
}
