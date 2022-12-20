package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.Role;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserRoleChangeRequestDTO {
    private long id;
    private Role role;
}
