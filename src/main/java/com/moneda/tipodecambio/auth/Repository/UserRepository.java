package com.moneda.tipodecambio.auth.Repository;

import com.moneda.tipodecambio.auth.Entity.UserEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UserRepository extends JpaRepository<UserEntity, Integer> {

    Optional<UserEntity> findByUsername(String nombreUsuario);
    boolean existsByUsername(String nombreUsuario);
    //boolean existsByEmail(String email);

}

