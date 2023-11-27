package com.moneda.tipodecambio.cambio.Service;

import com.moneda.tipodecambio.cambio.Entity.HistorialCambioEntity;
import com.moneda.tipodecambio.cambio.Entity.MonedasEntity;
import com.moneda.tipodecambio.cambio.Model.*;
import com.moneda.tipodecambio.cambio.Repository.HistorialCambioRepository;
import com.moneda.tipodecambio.cambio.Repository.MonedasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Optional;

@Service
public class TipoDeCambioServiceImpl implements TipoDeCambioService {

    @Autowired
    MonedasRepository monedasRepository;

    @Autowired
    HistorialCambioRepository historialCambioRepository;

    @Override
    public ResponseCambio cambioMoneda(RequestCambio cambio) {
        MonedasEntity moneda =  monedasRepository.findByMoneda(cambio.getMonedaDestino().toUpperCase());

        BigDecimal tipoCambioDolar = new BigDecimal(moneda.getTipoCambio().toString());
        BigDecimal montoConTipoDeCambio = cambio.getMonto().divide(tipoCambioDolar, 3, RoundingMode.HALF_EVEN);

        BigDecimal resultadoFormateado = quitarDecimalesCero(validarDecimalesCero(montoConTipoDeCambio));


        ResponseCambio responseCambio = new ResponseCambio();
        responseCambio.setMonto(cambio.getMonto());
        responseCambio.setMontoConTipoDeCambio(resultadoFormateado.toPlainString());
        responseCambio.setMonedaOrigen(cambio.getMonedaOrigen().toUpperCase());
        responseCambio.setMonedaDestino(cambio.getMonedaDestino().toUpperCase());
        responseCambio.setTipoDeCambio(tipoCambioDolar);


        historialCambioRepository.save(historialModelToEntity(responseCambio));

        return responseCambio;
    }

    @Override
    public MonedaModel actualizarDivisa(RequestActualizarDivisa cambio) {
        MonedasEntity moneda = monedasRepository.findByMoneda(cambio.getMoneda().toUpperCase());
        moneda.setTipoCambio(cambio.getTipoCambio());

        monedasRepository.save(moneda);

        return MonedaModel
                .builder()
                .id(moneda.getId())
                .moneda(moneda.getMoneda())
                .simbolo(moneda.getSimbolo())
                .tipoCambio(cambio.getTipoCambio())
                .build();
    }

    private HistorialCambioEntity historialModelToEntity(ResponseCambio responseCambio){

        return HistorialCambioEntity
                .builder()
                .monto(responseCambio.getMonto())
                .montoConTipoDeCambio(responseCambio.getMontoConTipoDeCambio())
                .monedaOrigen(responseCambio.getMonedaOrigen())
                .monedaDestino(responseCambio.getMonedaDestino())
                .tipoDeCambio(responseCambio.getTipoDeCambio())
                .build();

    }

    private static BigDecimal validarDecimalesCero(BigDecimal montoConTipoDeCambio) {
        int digitosDecimales = montoConTipoDeCambio.scale();
        BigDecimal resultadoAjustado;

        if (digitosDecimales == 2) {
            resultadoAjustado = montoConTipoDeCambio.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        } else if (digitosDecimales == 1) {
            resultadoAjustado = montoConTipoDeCambio.setScale(1, BigDecimal.ROUND_HALF_EVEN);
        } else if (digitosDecimales == 0) {
            resultadoAjustado = montoConTipoDeCambio.setScale(0, BigDecimal.ROUND_HALF_EVEN);
        } else {
            resultadoAjustado = montoConTipoDeCambio.setScale(2, BigDecimal.ROUND_HALF_EVEN);
        }
        return resultadoAjustado;
    }

    private static BigDecimal quitarDecimalesCero(BigDecimal numero) {
        return numero.stripTrailingZeros();
    }

}
