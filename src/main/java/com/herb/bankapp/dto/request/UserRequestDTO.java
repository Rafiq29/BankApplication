package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.Role;
import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    @ApiModelProperty(notes = "User First Name")
    private String firstname;
    @ApiModelProperty(notes = "User Last Name")
    private String lastname;
    @ApiModelProperty(notes = "User Father Name")
    private String fatherName;
    @ApiModelProperty(notes = "User Birthdate")
    private LocalDate birthdate;
    @ApiModelProperty(notes = "User Actual Address")
    private String acResidence;
    @ApiModelProperty(notes = "User Registered Address")
    private String regResidence;
    @ApiModelProperty(notes = "User Username")
    private String username;
    @ApiModelProperty(notes = "User password")
    private String password;
    @ApiModelProperty(notes = "User Role")
    private Role role;
}
