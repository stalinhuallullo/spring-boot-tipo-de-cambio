package com.moneda.tipodecambio.cambio.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.Builder;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class ResponseCambio {
    private BigDecimal monto;
    private String montoConTipoDeCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal tipoDeCambio;
}
