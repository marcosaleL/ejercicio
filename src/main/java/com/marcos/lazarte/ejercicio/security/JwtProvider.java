package com.marcos.lazarte.ejercicio.security;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import java.util.Base64;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import javax.annotation.PostConstruct;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

@Component
public class JwtProvider {

    @Value("${jwt.secret}")
    private String secret;

    @PostConstruct
    protected void init() {
        secret = Base64.getEncoder().encodeToString(secret.getBytes());
    }

    public String createToken(String email) {
        Map<String, Object> claims = new HashMap<>();
        claims = Jwts.claims().setSubject(email);
        return Jwts.builder().setClaims(claims).setIssuedAt(new Date()).setExpiration(new Date(new Date().getTime() + 3600 * 1000))
            .signWith(SignatureAlgorithm.HS256, secret).compact();

    }

    public boolean validate(String token) {
        try {
            Jwts.parser().setSigningKey(secret).parseClaimsJws(token);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}