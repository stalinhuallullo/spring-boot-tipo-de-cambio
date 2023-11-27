package com.moneda.tipodecambio.auth.Service;

import com.moneda.tipodecambio.auth.Entity.UserEntity;
import com.moneda.tipodecambio.auth.Model.UserPrincipal;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    UserService usuarioService;

    @Override
    public UserDetails loadUserByUsername(String nombreUsuario) throws UsernameNotFoundException {
        UserEntity usuario = usuarioService.getByNombreUsuario(nombreUsuario).get();
        return UserPrincipal.build(usuario);
    }
}
