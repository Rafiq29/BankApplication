package com.herb.bankapp.dto.response;

import com.herb.bankapp.entity.enums.Role;
import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserResponseDTO {
    private String firstname;
    private String lastname;
    private Role role;
}
