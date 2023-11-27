package com.moneda.tipodecambio.auth.Repository;

import com.moneda.tipodecambio.auth.Entity.RolEntity;
import com.moneda.tipodecambio.auth.enums.RolName;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface RolRepository extends JpaRepository<RolEntity, Integer> {
    Optional<RolEntity> findByRolNombre(RolName rolName);
}
