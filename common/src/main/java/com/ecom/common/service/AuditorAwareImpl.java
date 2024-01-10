package com.ecom.common.service;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.data.domain.AuditorAware;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service

public class AuditorAwareImpl implements AuditorAware<String> {

    private final HttpServletRequest httpServletRequest;
    public AuditorAwareImpl(HttpServletRequest httpServletRequest) {
        this.httpServletRequest = httpServletRequest;
    }
    @Override
    public Optional getCurrentAuditor() {
        return Optional.of(getClientIpAddress(httpServletRequest));
    }
    private String getClientIpAddress(HttpServletRequest httpServletRequest){
        String ipAddress = httpServletRequest.getHeader("X-Forwarded-For");
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)){
            ipAddress = httpServletRequest.getHeader("Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)){
            ipAddress = httpServletRequest.getHeader("WL-Proxy-Client-IP");
        }
        if (ipAddress == null || ipAddress.isEmpty() || "unknown".equalsIgnoreCase(ipAddress)){
            ipAddress = httpServletRequest.getRemoteAddr();
        }
        return ipAddress;
    }

}
