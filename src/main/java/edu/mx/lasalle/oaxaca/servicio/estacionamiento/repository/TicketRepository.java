package edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TicketModel;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TicketRepository extends JpaRepository<TicketModel, Long> {
    public TicketModel findById(long idTicket);
}
