package com.moneda.tipodecambio.auth.Service;

import com.moneda.tipodecambio.auth.Entity.RolEntity;
import com.moneda.tipodecambio.auth.Repository.RolRepository;
import com.moneda.tipodecambio.auth.enums.RolName;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Optional;

@Service
@Transactional
public class RolService {

    @Autowired
    RolRepository rolRepository;

    public Optional<RolEntity> getByRolNombre(RolName rolName){
        return rolRepository.findByRolNombre(rolName);
    }

    public void save(RolEntity rol){
        rolRepository.save(rol);
    }
}
