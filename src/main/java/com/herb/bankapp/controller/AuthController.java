package com.herb.bankapp.controller;

import com.herb.bankapp.dto.request.JwtRequest;
import com.herb.bankapp.dto.request.UserRequestDTO;
import com.herb.bankapp.dto.response.JwtResponse;
import com.herb.bankapp.dto.response.UserAuthResponseDTO;
import com.herb.bankapp.dto.response.UserResponseDTO;
import com.herb.bankapp.security.JwtTokenUtil;
import com.herb.bankapp.service.AuthService;
import com.herb.bankapp.service.UserService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.Authentication;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequiredArgsConstructor
@Api(value = "Authorization Related APIs")
public class AuthController {
    private final JwtTokenUtil jwtTokenUtil;
    private final AuthService authService;
    private final UserService userService;

    @ApiOperation(value = "Authenticate user and get a JWT token")
    @ApiResponse(code = 500, message = "Unknown error")
    @PostMapping("/authenticate")
    public JwtResponse createAuthenticationToken(@RequestBody JwtRequest request) {
        Authentication authenticate = authService.authenticate(request.getUsername(), request.getPassword());
        String token = jwtTokenUtil.generateToken(authenticate);
        return new JwtResponse(token);
    }

    @ApiOperation(value = "Register a user")
    @ApiResponses(value = {
            @ApiResponse(code = 400, message = "User already exists"),
            @ApiResponse(code = 500, message = "Unknown error")
    })
    @PostMapping("/register")
    public UserResponseDTO save(@RequestBody UserRequestDTO requestDTO) {
        return userService.add(requestDTO);
    }

    @ApiOperation(value = "Get a list of all registered users")
    @ApiResponse(code = 500, message = "Unknown error")
    @PostMapping("/all")
    public List<UserAuthResponseDTO> getAll() {
        return authService.getAll();
    }
}
