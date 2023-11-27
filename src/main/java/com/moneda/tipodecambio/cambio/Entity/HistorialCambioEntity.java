package com.moneda.tipodecambio.cambio.Entity;

import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Getter
@Setter
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "Changehistory")
public class HistorialCambioEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    private BigDecimal monto;
    private String montoConTipoDeCambio;
    private String monedaOrigen;
    private String monedaDestino;
    private BigDecimal tipoDeCambio;
}
