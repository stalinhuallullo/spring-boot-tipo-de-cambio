package com.moneda.tipodecambio.auth.Service;

import com.moneda.tipodecambio.auth.Entity.UserEntity;
import com.moneda.tipodecambio.auth.Repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import java.util.Optional;


@Service
@Transactional
public class UserService {

    @Autowired
    UserRepository userRepository;

    public Optional<UserEntity> getByNombreUsuario(String username){
        return userRepository.findByUsername(username);
    }
    public boolean existsByNombreUsuario(String username){
        return userRepository.existsByUsername(username);
    }
    public void save(UserEntity userEntity){
        userRepository.save(userEntity);
    }

}
