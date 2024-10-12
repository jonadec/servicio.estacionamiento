package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.MotocicletaModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.MotocicletaRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.MotocicletaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MotocicletaServiceImplements implements MotocicletaService {

    @Autowired
    private MotocicletaRepository motocicletaRepository;

    @Override
    public MotocicletaModel registrarMotocicleta(MotocicletaModel motocicletaModel) {
        return motocicletaRepository.save(motocicletaModel);
    }

    @Override
    public List<MotocicletaModel> obtenerMotocicletas() {
        return motocicletaRepository.findAll();
    }

    @Override
    public MotocicletaModel getMotocicleta(long id) {
        return motocicletaRepository.findById(id);
    }

    @Override
    public void actualizarDatosMotocicleta(MotocicletaModel motocicletaModel, long id) {
        MotocicletaModel motocicletaExistente = getMotocicleta(id);
        if (motocicletaExistente != null) {
            motocicletaExistente.setTieneCasco(motocicletaModel.isTieneCasco());
            motocicletaExistente.setPlaca(motocicletaModel.getPlaca());
            motocicletaExistente.setTipo(motocicletaModel.getTipo());
            motocicletaExistente.setColor(motocicletaModel.getColor());
            motocicletaExistente.setConductor(motocicletaModel.getConductor());
            motocicletaRepository.save(motocicletaExistente);
        }
    }

    @Override
    public void borrarMotocicleta(long id) {
        motocicletaRepository.deleteById(id);
    }
}
