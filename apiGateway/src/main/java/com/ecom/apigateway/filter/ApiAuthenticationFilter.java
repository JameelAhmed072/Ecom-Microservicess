package com.ecom.apigateway.filter;


import com.ecom.apigateway.endpoints.PublicEndPoints;
import com.ecom.apigateway.util.JwtUtil;
import org.springframework.cloud.gateway.filter.GatewayFilter;
import org.springframework.cloud.gateway.filter.factory.AbstractGatewayFilterFactory;
import org.springframework.http.HttpHeaders;
import org.springframework.stereotype.Component;

@Component
public class ApiAuthenticationFilter extends AbstractGatewayFilterFactory<ApiAuthenticationFilter.Config> {

    private PublicEndPoints publicEndPoints;

    private JwtUtil jwtUtil;
    public ApiAuthenticationFilter(PublicEndPoints publicEndPoints,JwtUtil jwtUtil){
        super(Config.class);
        this.publicEndPoints = publicEndPoints;
        this.jwtUtil = jwtUtil;
    }

    @Override
    public GatewayFilter apply(Config config) {
        return ((exchange, chain) -> {
                if (publicEndPoints.isPublic.test(exchange.getRequest())) {
                    if (!exchange.getRequest().getHeaders().containsKey(HttpHeaders.AUTHORIZATION)) {
                        throw new RuntimeException("Please Provide Jwt Token");
                    }
                }
                    String jwtTokenWithBearer = exchange.getRequest().getHeaders().get(HttpHeaders.AUTHORIZATION).get(0);
                    String jwtToken = null;
                    if (jwtTokenWithBearer != null && jwtTokenWithBearer.startsWith("Bearer ")){
                        jwtToken = jwtTokenWithBearer.substring(7);
                    }
                    jwtUtil.validateToken(jwtToken);
                    return chain.filter(exchange);

        });
    }

    public static class Config{}

}
