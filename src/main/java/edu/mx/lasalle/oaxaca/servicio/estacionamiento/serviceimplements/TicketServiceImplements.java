package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TicketModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.TicketRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.TicketService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio para la gestión de tickets.
 */
@Service
public class TicketServiceImplements implements TicketService {

    @Autowired
    private TicketRepository ticketRepository;

    @Override
    public void registrarTicket(TicketModel ticketModel) {
        ticketRepository.save(ticketModel);
    }

    @Override
    public List<TicketModel> obtenerTickets() {
        return ticketRepository.findAll();
    }

    @Override
    public TicketModel getTicket(Long id) {
        return ticketRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarDatosTicket(TicketModel ticketModel, Long id) {
        if (ticketRepository.existsById(id)) {
            ticketModel.setIdTicket(id);
            ticketRepository.save(ticketModel);
        }
    }

    @Override
    public void borrarTicket(Long id) {
        if (ticketRepository.existsById(id)) {
            ticketRepository.deleteById(id);
        }
    }

    @Override
    public void borrarTodosLosTickets() {
        ticketRepository.deleteAll();
    }
}
