package com.herb.bankapp.dto.response;

import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class JwtResponse implements Serializable {
    private final String jwtToken;
    private String type = "Bearer";
}
