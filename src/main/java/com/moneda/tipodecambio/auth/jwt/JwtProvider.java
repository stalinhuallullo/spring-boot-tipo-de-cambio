package com.moneda.tipodecambio.auth.jwt;

import com.moneda.tipodecambio.auth.Model.UserPrincipal;
import io.jsonwebtoken.*;
import io.jsonwebtoken.security.SignatureException;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.stereotype.Component;

import java.util.Date;

@Component
public class JwtProvider {
    //private final static Logger logger = LoggerFactory.getLogger(JwtProvider.class);

    @Value("${jwt.secret}")
    private String secret;

    @Value("${jwt.expiration}")
    private int expiration;

    public String generateToken(Authentication authentication){
        UserPrincipal usuarioPrincipal = (UserPrincipal) authentication.getPrincipal();
        return Jwts.builder().setSubject(usuarioPrincipal.getUsername())
                .setIssuedAt(new Date())
                .setExpiration(new Date(new Date().getTime() + expiration * 1000))
                .signWith(SignatureAlgorithm.HS512, secret)
                .compact();
    }

    public String getNombreUsuarioFromToken(String token){
        return Jwts.parser().setSigningKey(secret).parseClaimsJws(token).getBody().getSubject();
    }

    public boolean validateToken(String token){
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        }catch (MalformedJwtException e){
            //logger.error("token mal formado");
            System.out.println("token mal formado");
        }catch (UnsupportedJwtException e){
            System.out.println("token no soportado");
        }catch (ExpiredJwtException e){
            System.out.println("token expirado");
        }catch (IllegalArgumentException e){
            System.out.println("token vacío");
        }catch (SignatureException e){
            System.out.println("fail en la firma");
        }
        return false;
    }
}