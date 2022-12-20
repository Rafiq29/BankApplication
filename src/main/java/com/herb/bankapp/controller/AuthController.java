package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.JwtRequest;
import com.herb.bankapp.dto.request.UserRequestDTO;
import com.herb.bankapp.dto.response.JwtResponse;
import com.herb.bankapp.dto.response.UserAuthResponseDTO;
import com.herb.bankapp.dto.response.UserResponseDTO;
import com.herb.bankapp.security.JwtTokenUtil;
import com.herb.bankapp.service.AuthService;
import com.herb.bankapp.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthService authService;
    private final UserService userService;

    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest request) {
        Authentication authenticate = authService.authenticate(request.getUsername(), request.getPassword());
        String token = jwtTokenUtil.generateToken(authenticate);
        return new JwtResponse(token);
    }

    @PostMapping("/register")
    public UserResponseDTO save(@RequestBody UserRequestDTO requestDTO) {
        return userService.add(requestDTO);
    }

    @PostMapping("/all")
    public List<UserAuthResponseDTO> getAll() {
        return authService.getAll();
    }
}
