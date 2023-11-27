package com.moneda.tipodecambio.cambio.Service;

import com.moneda.tipodecambio.cambio.Model.*;

public interface TipoDeCambioService {

    ResponseCambio cambioMoneda(RequestCambio cambio);
    MonedaModel actualizarDivisa(RequestActualizarDivisa cambio);
}
