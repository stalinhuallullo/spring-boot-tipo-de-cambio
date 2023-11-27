package com.moneda.tipodecambio.cambio.Repository;

import com.moneda.tipodecambio.cambio.Entity.MonedasEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface MonedasRepository extends JpaRepository<MonedasEntity, Integer>{

    @Query("SELECT M FROM MonedasEntity AS M WHERE M.moneda = :moneda")
    MonedasEntity findByMoneda(@Param("moneda") String moneda);

}
