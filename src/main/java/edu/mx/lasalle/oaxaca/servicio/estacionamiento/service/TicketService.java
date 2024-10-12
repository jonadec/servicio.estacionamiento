package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TicketModel;
import java.util.List;

public interface TicketService {
    
    // Registrar un nuevo ticket
    void registrarTicket(TicketModel ticketModel);
    
    // Obtener una lista de todos los tickets registrados
    List<TicketModel> obtenerTickets();
    
    // Obtener un ticket por su ID
    TicketModel getTicket(Long id);
    
    // Actualizar los datos de un ticket
    void actualizarDatosTicket(TicketModel ticketModel, Long id);
    
    // Eliminar un ticket por su ID
    void borrarTicket(Long id);
    
    // Eliminar todos los tickets registrados
    void borrarTodosLosTickets();
}
