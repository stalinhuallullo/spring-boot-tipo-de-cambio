package com.moneda.tipodecambio.cambio.Model;


import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@AllArgsConstructor
@NoArgsConstructor
@Builder
public class RequestCambio {
    // BigDecimal uno = new BigDecimal(2.3);
    private BigDecimal monto;
    private String monedaOrigen;
    private String monedaDestino;
}
