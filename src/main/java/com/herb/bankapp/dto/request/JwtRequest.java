package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class JwtRequest {
    @ApiModelProperty(notes = "User username")
    private String username;
    @ApiModelProperty(notes = "User password")
    private String password;
    @ApiModelProperty(notes = "User role (CUSTOMER, EMPLOYEE, ADMIN)")
    private Role role;
}
