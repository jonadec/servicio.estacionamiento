package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.EspacioModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.EspacioRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.EspacioService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * Implementación del servicio para la gestión de espacios.
 */
@Service
public class EspacioServiceImplements implements EspacioService {

    @Autowired
    private EspacioRepository espacioRepository;

    @Override
    public void registrarEspacio(EspacioModel espacioModel) {
        espacioRepository.save(espacioModel);
    }

    @Override
    public List<EspacioModel> obtenerEspacios() {
        return espacioRepository.findAll();
    }

    @Override
    public EspacioModel getEspacio(Long id) {
        return espacioRepository.findById(id).orElse(null);
    }

    @Override
    public void actualizarDatosEspacio(EspacioModel espacioModel, Long id) {
        if (espacioRepository.existsById(id)) {
            espacioModel.setId(id);
            espacioRepository.save(espacioModel);
        }
    }

    @Override
    public void borrarEspacio(Long id) {
        if (espacioRepository.existsById(id)) {
            espacioRepository.deleteById(id);
        }
    }

    @Override
    public void borrarTodosLosEspacios() {
        espacioRepository.deleteAll();
    }
}
