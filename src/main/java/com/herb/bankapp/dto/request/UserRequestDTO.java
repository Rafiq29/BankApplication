package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRequestDTO {
    private String firstname;
    private String lastname;
    private String fatherName;
    private LocalDate birthdate;
    private String acResidence;
    private String regResidence;
    private String username;
    private String password;
    private Role role;
}
