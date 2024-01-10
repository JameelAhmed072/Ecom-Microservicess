package com.ecom.auth.service.impl;

import com.ecom.auth.dto.CustomUserDetails;
import com.ecom.auth.model.User;
import com.ecom.auth.repo.UserRepository;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class CustomUserDetailService implements UserDetailsService {
    private UserRepository userRepository;

    public CustomUserDetailService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {

        Optional<User> optionalUser = userRepository.findByUserName(username);

        return optionalUser.map(CustomUserDetails::new).orElseThrow(()-> new RuntimeException("Invalid Access"));
    }
}
