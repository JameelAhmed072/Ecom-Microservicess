package com.ecom.apigateway.util;

import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

@Component
public class JwtUtil {

    public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";


    public String GenerateToken(String userName){
        Map<String, Object> claims = new HashMap<>();
        return createToken(claims,userName);
    }


    private String createToken(Map<String, Object> claims, String userName){

        return Jwts.builder()
                .setClaims(claims)
                .setSubject(userName)
                .setIssuedAt(new Date(System.currentTimeMillis()))
                .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *30))
                .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String validateToken(String jwtToken){
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(jwtToken);
        return "Valid Token";
    }

}
