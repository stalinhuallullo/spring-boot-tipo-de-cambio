package com.moneda.tipodecambio.cambio.Model;

import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class MonedaModel {
    private int id;
    private String moneda;
    private String simbolo;
    private BigDecimal tipoCambio;
}
