package com.glamora.ref.common.security;

import io.jsonwebtoken.*;
import io.jsonwebtoken.security.Keys;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    @Value("${jwt.secret}")
    private String SECRET_KEY;


    public String generateToken(String userName, Long uId, String fname, String lname) {
        Map<String, Object> claims = new HashMap();
        claims.put("uId", uId);
        claims.put("fn", fname);
        claims.put("ln", lname);
        return this.doGenerateToken(claims,userName);
    }

    private String doGenerateToken(Map<String, Object> claims, String subject) {
        return Jwts.builder().setClaims(claims).setSubject(subject).setIssuedAt(new Date(System.currentTimeMillis())).setExpiration(new Date(System.currentTimeMillis() + 3600000L)).signWith(Keys.hmacShaKeyFor(this.SECRET_KEY.getBytes()), SignatureAlgorithm.HS512).compact();
    }

    public Claims parse(String jwt) {
        return Jwts.parserBuilder()
                .setSigningKey(SECRET_KEY)
                .build()
                .parseClaimsJws(jwt)
                .getBody();
    }

    public boolean isValid(String jwt) {
        try {
            parse(jwt);
            return true;
        } catch (JwtException | IllegalArgumentException e) {
            return false;
        }
    }

    public String getSubject(String jwt) {
        return parse(jwt).getSubject();
    }
}
