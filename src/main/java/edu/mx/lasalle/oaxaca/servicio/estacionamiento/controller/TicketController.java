package edu.mx.lasalle.oaxaca.servicio.estacionamiento.controller;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TicketModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.TicketService;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.utils.CustomResponse;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/v1/ticket")
public class TicketController {

    @Autowired
    private TicketService ticketService;

    @PostMapping("/registro")
    public CustomResponse registrarTicket(@RequestBody TicketModel ticketModel) {
        CustomResponse customResponse = new CustomResponse();
        ticketService.registrarTicket(ticketModel);
        customResponse.setHttpCode(HttpStatus.CREATED);
        customResponse.setCode(201);
        customResponse.setMessage("TICKET REGISTRADO EXITOSAMENTE");
        return customResponse;
    }

    @GetMapping("/registros")
    public ResponseEntity<List<TicketModel>> getAllTickets() {
        List<TicketModel> tickets = ticketService.obtenerTickets();
        if (tickets.isEmpty()) {
            return new ResponseEntity<>(HttpStatus.NO_CONTENT);
        }
        return new ResponseEntity<>(tickets, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Object> getTicket(@PathVariable long id) {
        try {
            TicketModel ticket = ticketService.getTicket(id);
            if (ticket != null) {
                return ResponseEntity.status(HttpStatus.OK).body(
                    new CustomResponse(HttpStatus.OK, ticket, "Ticket encontrado", 200)
                );
            } else {
                return ResponseEntity.status(HttpStatus.NOT_FOUND).body(
                    new CustomResponse(HttpStatus.NOT_FOUND, null, "Ticket no encontrado", 404)
                );
            }
        } catch (Exception e) {
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(
                new CustomResponse(HttpStatus.UNPROCESSABLE_ENTITY, null, "ERROR: " + e, 422)
            );
        }
    }

    @PutMapping("/{id}/actualizar")
    public ResponseEntity<Object> updateTicket(@RequestBody TicketModel ticketModel, @PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            TicketModel ticketExistente = ticketService.getTicket(id);
            if (ticketExistente == null) {
                return ResponseEntity.status(HttpStatus.NO_CONTENT).body(
                    new CustomResponse(HttpStatus.NO_CONTENT, "", "No se encontró ticket con el id= " + id, 204)
                );
            }
            ticketService.actualizarDatosTicket(ticketModel, id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Ticket actualizado con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage("Error: " + e);
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        }
    }

    @DeleteMapping("/{id}/borrar")
    public ResponseEntity<Object> deleteTicket(@PathVariable long id) {
        CustomResponse customResponse = new CustomResponse();
        try {
            ticketService.borrarTicket(id);
            customResponse.setHttpCode(HttpStatus.OK);
            customResponse.setCode(200);
            customResponse.setMessage("Ticket eliminado con éxito");
            return ResponseEntity.status(HttpStatus.OK).body(customResponse);
        } catch (Exception e) {
            customResponse.setMessage(e.getMessage());
            return ResponseEntity.status(HttpStatus.UNPROCESSABLE_ENTITY).body(customResponse);
        }
    }
}
