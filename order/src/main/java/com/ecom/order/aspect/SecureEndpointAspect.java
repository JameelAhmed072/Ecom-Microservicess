package com.ecom.order.aspect;

import com.ecom.order.annotation.SecureEndpoint;
import io.jsonwebtoken.Jwts;
import io.jsonwebtoken.io.Decoders;
import io.jsonwebtoken.security.Keys;
import jakarta.servlet.http.HttpServletRequest;
import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

import java.security.Key;
import java.util.Arrays;
import java.util.List;

@Aspect
@Component
public class SecureEndpointAspect {
    public static final String SECRET = "357638792F423F4428472B4B6250655368566D597133743677397A2443264629";
    private HttpServletRequest request;
    public SecureEndpointAspect(HttpServletRequest request) {
        this.request = request;
    }
    @Before("@annotation(secureEndpoint)")
    public void securingMethod(JoinPoint joinPoint , SecureEndpoint secureEndpoint) throws Exception{
        String[] values = secureEndpoint.value();
        String methodName = joinPoint.getSignature().getName();

        if(Arrays.stream(values).toList().isEmpty()){
            throw new Exception("No Permission is mentioned. ");
        }
        String authentication = this.request.getHeader("AUTHORIZATION");
        String jwtToken = null;
        if (authentication == null){
            System.out.println("Method Name "+ methodName);
            throw new Exception("You dont have required permissions to access this endpoint...");
        }else {
            jwtToken = authentication.substring(7);
            String isValid = validateToken(jwtToken);
            if(!isValid.equalsIgnoreCase("Valid Token")){
                throw new Exception("Your Jwt token is not valid..");
            }
        }
        List<String> userPermissions = getAllPermissionFromJwtToken(jwtToken);
        boolean isPermitted = false;

        for (String value : values) {
            for (String permission : userPermissions) {
                if (permission.equalsIgnoreCase(value)) {
                    isPermitted = true;
                    break;
                }
            }
        }
        if (!isPermitted){
            System.out.println("Method Name "+ methodName);
            throw new Exception("You dont have required permissions to access this endpoint...");
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
    public List<String> getAllPermissionFromJwtToken(String jwtToken){
        List<String> permission = (List<String>) Jwts.parserBuilder().setSigningKey(getSignKey()).build().parseClaimsJws(jwtToken).getBody().get("permission");
        return permission;
    }
}
