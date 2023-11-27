package com.moneda.tipodecambio.data;

import com.moneda.tipodecambio.auth.Entity.UserEntity;
import com.moneda.tipodecambio.auth.Model.Role;
import com.moneda.tipodecambio.auth.Repository.UserRepository;
import com.moneda.tipodecambio.cambio.Entity.MonedasEntity;
import com.moneda.tipodecambio.cambio.Repository.MonedasRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.ApplicationArguments;
import org.springframework.boot.ApplicationRunner;
import org.springframework.stereotype.Component;

import java.math.BigDecimal;
import java.util.Arrays;
import java.util.List;

@Component
public class MonedasDataLoader implements ApplicationRunner {

    @Autowired
    MonedasRepository monedasRepository;

    @Autowired
    UserRepository userRepository;

    @Override
    public void run(ApplicationArguments args) throws Exception {

        /*List<UserEntity> userEntities = Arrays.asList(
                UserEntity.builder().id(1).username("taylorswift").firstname("Taylor").lastname("Swift").password("t1234").role(Role.ADMIN).build(),
                UserEntity.builder().id(2).username("stalin").firstname("Stalin").lastname("Huallullo").password("t1234").role(Role.USER).build()
        );
        userRepository.saveAll(userEntities);*/

        List<MonedasEntity> monedas = Arrays.asList(
                MonedasEntity.builder().moneda("DOLAR").simbolo("$").tipoCambio(new BigDecimal("3.748")).build(),
                MonedasEntity.builder().moneda("SOLES").simbolo("S/").tipoCambio(new BigDecimal("1")).build(),
                MonedasEntity.builder().moneda("EURO").simbolo("€").tipoCambio(new BigDecimal("4.08")).build()
        );
        monedasRepository.saveAll(monedas);
    }
}
