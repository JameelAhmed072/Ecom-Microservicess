package com.ecom.auth.service.impl;

import com.ecom.auth.dto.CustomJwt;
import com.ecom.auth.helper.AuthHelper;
import com.ecom.auth.model.User;
import com.ecom.auth.repo.UserRepository;
import com.ecom.auth.service.AuthService;
import com.ecom.auth.util.JwtUtil;
import com.ecom.common.dto.UserResponse;
import org.springframework.stereotype.Service;

@Service
public class AuthServiceImpl implements AuthService {

    private JwtUtil jwtUtil;
    private UserRepository userRepository;

    public AuthServiceImpl(JwtUtil jwtUtil, UserRepository userRepository) {
        this.jwtUtil = jwtUtil;
        this.userRepository = userRepository;
    }

    @Override
    public CustomJwt generateToken(UserResponse userResponse) {
        User user = this.userRepository.findByUserName(userResponse
                .getUserName()).orElseThrow(() -> new RuntimeException("Invalid access"));


        return AuthHelper.makeCustomJwt(user,this.jwtUtil.GenerateToken(userResponse.getUserName()));
    }

    @Override
    public String validateToken(String jwtToken) {
        return this.jwtUtil.validateToken(jwtToken);
    }
}