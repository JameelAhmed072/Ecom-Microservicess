package com.ecom.auth.util;

import com.ecom.auth.helperEnums.TokenType;
import com.ecom.auth.model.Permission;
import com.ecom.auth.model.User;
import io.jsonwebtoken.ExpiredJwtException;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.SignatureAlgorithm;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import org.apache.el.parser.Token;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.*;

@Component
public class JwtUtil {

    public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";


    public String GenerateToken(User user, TokenType tokenType){
        Map<String, Object> claims = new HashMap<>();
        List<String> permissionList = new ArrayList<>();
        String userRole = user.getUserRole();
        List<Permission> permission = user.getPermission();
        permissionList.add(userRole);
        if(permission != null && !permission.isEmpty()){
            permission.stream().forEach(e->{
                permissionList.add(e.getPermissionString());
            });
        }else
            claims.put("permission",permissionList);
        return createToken(claims,user.getUserName(),tokenType);
    }
    private String createToken(Map<String, Object> claims, String userName, TokenType tokenType){
        if (tokenType.equals(TokenType.REFRESG_TOKEN)){
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(userName)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 7))
                    .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
        } else if (tokenType.equals(TokenType.REQUEST_TOKEN)) {
            return Jwts.builder()
                    .setClaims(claims)
                    .setSubject(userName)
                    .setIssuedAt(new Date(System.currentTimeMillis()))
                    .setExpiration(new Date(System.currentTimeMillis() + 1000 * 60 *30))
                    .signWith(getSignKey(), SignatureAlgorithm.HS256).compact();
        }else{
            return "";
        }


    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }

    public String validateToken(String jwtToken){
        Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(jwtToken);
        return "Valid Token";
    }
    public String getUserNameFromToken(String jwtToken){
        try {
            return Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(jwtToken).getBody().getSubject();
        }catch (ExpiredJwtException ex){
            ex.printStackTrace();
            return ex.getClaims().getSubject();
        }
        catch (Exception e){
            e.printStackTrace();
            return null;
        }
    }
}
