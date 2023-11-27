package com.moneda.tipodecambio.cambio.Model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class RequestActualizarDivisa {
    private String moneda;
    private BigDecimal tipoCambio;
}
