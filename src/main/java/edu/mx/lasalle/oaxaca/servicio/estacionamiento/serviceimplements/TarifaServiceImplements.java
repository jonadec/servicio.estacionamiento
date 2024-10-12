package edu.mx.lasalle.oaxaca.servicio.estacionamiento.serviceimplements;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TarifaModel;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.repository.TarifaRepository;
import edu.mx.lasalle.oaxaca.servicio.estacionamiento.service.TarifaService;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class TarifaServiceImplements implements TarifaService {

    @Autowired
    private TarifaRepository tarifaRepository;

    @Override
    public void registrarTarifa(TarifaModel tarifaModel) {
        tarifaRepository.save(tarifaModel);
    }

    @Override
    public List<TarifaModel> obtenerTarifas() {
        return tarifaRepository.findAll();
    }

    @Override
    public TarifaModel getTarifa(long id) {
        return tarifaRepository.findById(id);
    }

    @Override
    public void actualizarDatosTarifa(TarifaModel tarifaModel, long id) {
        if (tarifaRepository.existsById(id)) {
            tarifaModel.setIdTarifa(id); 
            tarifaRepository.save(tarifaModel);
        }
    }

    @Override
    public void borrarTarifa(long id) {
        if (tarifaRepository.existsById(id)) {
            tarifaRepository.deleteById(id);
        }
    }

    @Override
    public void borrarTodasLasTarifas() {
        tarifaRepository.deleteAll();
    }
}
