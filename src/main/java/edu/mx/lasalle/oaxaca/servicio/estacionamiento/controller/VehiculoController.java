package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.VehiculoModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.VehiculoService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Controlador para gestionar las operaciones relacionadas con los vehículos.
 */
@RestController
@CrossOrigin(origins = "*")
@RequestMapping("/api/v1/vehiculo")
public class VehiculoController {

    @Autowired
    private VehiculoService vehiculoService;

    @PostMapping("/registro")
    public CustomResponse registrarVehiculo(@RequestBody VehiculoModel vehiculoModel) {
        CustomResponse customResponse = new CustomResponse();
        vehiculoService.registrarVehiculo(vehiculoModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("VEHÍCULO REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<VehiculoModel>> obtenerTodosLosVehiculos() {
        List<VehiculoModel> vehiculos = vehiculoService.obtenerVehiculos();
        if (vehiculos.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(vehiculos, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> obtenerVehiculo(@PathVariable Long id) {
        try {
            VehiculoModel vehiculo = vehiculoService.getVehiculo(id);
            if (vehiculo == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new CustomResponse(HttpStatus.NOT_FOUND, "", "Vehículo no encontrado", 404)
                );
            }
            return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, vehiculo, "Vehículo encontrado", 200)
            );
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                    new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, "", "Error: " + e.getMessage(), 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> actualizarVehiculo(@RequestBody VehiculoModel vehiculoModel, @PathVariable Long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            VehiculoModel vehiculoExistente = vehiculoService.getVehiculo(id);
            if (vehiculoExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new CustomResponse(HttpStatus.NOT_FOUND, "", "Vehículo no encontrado con id= " + id, 404)
                );
            }
            vehiculoService.actualizarVehiculo(vehiculoModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Vehículo actualizado exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> borrarVehiculo(@PathVariable Long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            VehiculoModel vehiculoExistente = vehiculoService.getVehiculo(id);
            if (vehiculoExistente == null) {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                        new CustomResponse(HttpStatus.NOT_FOUND, "", "Vehículo no encontrado con id= " + id, 404)
                );
            }
            vehiculoService.borrarVehiculo(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Vehículo eliminado exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }

    @DeleteMapping("/borrar-todos")
    public ResponseEntity<Object> borrarTodosLosVehiculos() {
        CustomResponse customResponse = new CustomResponse();
        try {
            vehiculoService.borrarTodosLosVehiculos();
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Todos los vehículos fueron eliminados exitosamente");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
