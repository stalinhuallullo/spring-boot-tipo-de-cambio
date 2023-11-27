package com.moneda.tipodecambio.data;

import com.moneda.tipodecambio.auth.Entity.RolEntity;
import com.moneda.tipodecambio.auth.Entity.UserEntity;
import com.moneda.tipodecambio.auth.Model.Role;
import com.moneda.tipodecambio.auth.Repository.UserRepository;
import com.moneda.tipodecambio.auth.enums.RolName;
import com.moneda.tipodecambio.cambio.Entity.MonedasEntity;
import com.moneda.tipodecambio.cambio.Repository.MonedasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashSet;
import java.util.List;

@Component
public class UsersDataLoader implements ApplicationRunner {

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        List<UserEntity> userEntities = Arrays.asList(
                UserEntity
                        .builder()
                        .id(1)
                        .username("taylorswift")
                        .firstname("Taylor")
                        .lastname("Swift")
                        .password("t1234")
                        .roles(new HashSet<>(Collections.singletonList(RolEntity.builder().rolName(RolName.ROLE_USER).build())))
                        .build(),
                UserEntity
                        .builder()
                        .id(2)
                        .username("stalin")
                        .firstname("Stalin")
                        .lastname("Huallullo")
                        .password("t1234")
                        .roles(new HashSet<>(Collections.singletonList(RolEntity.builder().rolName(RolName.ROLE_ADMIN).build())))
                        .build()
        );
        userRepository.saveAll(userEntities);

    }
}
