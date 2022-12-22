package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleChangeRequestDTO {
    @ApiModelProperty(notes = "User ID")
    private long id;
    @ApiModelProperty(notes = "User Role")
    private Role role;
}
