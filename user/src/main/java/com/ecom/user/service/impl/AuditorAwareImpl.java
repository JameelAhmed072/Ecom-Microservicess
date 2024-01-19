package com.ecom.user.service.impl;

import com.ecom.user.pattern.UserNameSingleton;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.security.Key;
import java.util.Optional;

@Service
public class AuditorAwareImpl implements AuditorAware<String> {

    public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";
    private final HttpServletRequest httpServletRequest;
    public AuditorAwareImpl(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    @Override
    public Optional getCurrentAuditor() {
        String authorization = httpServletRequest.getHeader("AUTHORIZATION");
        if (authorization == null){
            return Optional.of(UserNameSingleton.getInstance().getUserName());
        }else {
            String jwtToken = authorization.substring(7);
            String userName = Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(jwtToken).getBody().getSubject();
            return Optional.of(userName);
        }
    }
    private Key getSignKey() {
        byte[] keyBytes = Decoders.BASE64.decode(SECRET);
        return Keys.hmacShaKeyFor(keyBytes);
    }
}
