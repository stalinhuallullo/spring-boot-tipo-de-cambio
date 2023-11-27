package com.moneda.tipodecambio.cambio.Repository;

import com.moneda.tipodecambio.cambio.Entity.HistorialCambioEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HistorialCambioRepository extends JpaRepository<HistorialCambioEntity, Integer> {



}
