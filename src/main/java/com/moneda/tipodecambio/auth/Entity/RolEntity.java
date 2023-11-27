package com.moneda.tipodecambio.auth.Entity;

import com.moneda.tipodecambio.auth.enums.RolName;
import jakarta.persistence.*;
import lombok.*;

@Getter
@Setter
@Builder
@Entity
@Table(name="Users")
public class RolEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @NonNull
    @Enumerated(EnumType.STRING)
    private RolName rolName;
}
