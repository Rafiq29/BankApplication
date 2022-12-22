package com.herb.bankapp.dto.response;

import io.swagger.annotations.ApiModelProperty;
import lombok.Data;
import lombok.RequiredArgsConstructor;

import java.io.Serializable;

@Data
@RequiredArgsConstructor
public class JwtResponse implements Serializable {
    @ApiModelProperty(notes = "JWT Token")
    private final String jwtToken;
    @ApiModelProperty(notes = "JWT Token Type")
    private String type = "Bearer";
}
