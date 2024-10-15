package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TarifaModel;
import java.util.List;

public interface TarifaService {
    public void registrarTarifa(TarifaModel tarifaModel);
    public List<TarifaModel> obtenerTarifas();
    public TarifaModel getTarifa(long id);
    public void actualizarDatosTarifa(TarifaModel tarifaModel, long id);
    public void borrarTarifa(long id);
    public void borrarTodasLasTarifas();
}
