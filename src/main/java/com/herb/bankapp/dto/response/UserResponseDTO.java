package com.herb.bankapp.dto.response;

import com.herb.bankapp.entity.enums.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    @ApiModelProperty(notes = "User First Name")
    private String firstname;
    @ApiModelProperty(notes = "User Last Name")
    private String lastname;
    @ApiModelProperty(notes = "User Role")
    private Role role;
}
