package edu.mx.lasalle.oaxaca.servicio.estacionamiento.service;

import edu.mx.lasalle.oaxaca.servicio.estacionamiento.model.TarifaModel;
import java.util.List;

public interface TarifaService {
    // Método para registrar una nueva tarifa
    public void registrarTarifa(TarifaModel tarifaModel);
    
    // Método para obtener todas las tarifas
    public List<TarifaModel> obtenerTarifas();
    
    // Método para obtener una tarifa por ID
    public TarifaModel getTarifa(long id);
    
    // Método para actualizar una tarifa
    public void actualizarDatosTarifa(TarifaModel tarifaModel, long id);
    
    // Método para eliminar una tarifa
    public void borrarTarifa(long id);

    public void borrarTodasLasTarifas();
}
