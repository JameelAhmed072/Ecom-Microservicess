package com.ecom.apigateway.endpoints;


import org.springframework.http.server.reactive.ServerHttpRequest;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.function.Predicate;

@Component
public class PublicEndPoints {


    public static final List<String> publicEndpoints = List.of("/auth/generateToken","/eureka","/auth/generateRefreshToken");

    public Predicate<ServerHttpRequest> isPublic =
                    serverHttpRequest -> publicEndpoints.stream().noneMatch(publicUris -> serverHttpRequest.getURI().getPath().contains(publicUris));
}
