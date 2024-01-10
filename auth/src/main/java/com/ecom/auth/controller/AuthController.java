package com.ecom.auth.controller;


import com.ecom.auth.dto.CustomJwt;
import com.ecom.auth.service.AuthService;
import com.ecom.common.dto.UserResponse;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/auth")
public class AuthController {

    private AuthService authService;

    private AuthenticationManager authenticationManager;

    public AuthController(AuthService authService, AuthenticationManager authenticationManager) {
        this.authService = authService;
        this.authenticationManager = authenticationManager;
    }

    @PostMapping("/generateToken")
    public CustomJwt generateToken(@RequestBody UserResponse userResponse){
        Authentication authenticate = this.authenticationManager.authenticate(
                new UsernamePasswordAuthenticationToken(userResponse.getUserName(), userResponse.getUserPassword()));
        if(authenticate.isAuthenticated())
            return this.authService.generateToken(userResponse);
        else
            throw new RuntimeException("Invalid Access");
    }


    @GetMapping("/validateToken")
    private String validateToken(@RequestParam("jwtToken") String jwtToken){
        return this.authService.validateToken(jwtToken);
    }
}
