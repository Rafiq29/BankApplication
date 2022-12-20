package com.herb.bankapp.dto.response;

import com.herb.bankapp.entity.enums.RequestStatus;
import lombok.*;

import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountResponseDTO {
    private int iban;
    private int number;
    private String holder_firstname;
    private String holder_lastname;
    private List<CardResponseDTO> cards;
    private UserResponseDTO user;
    private RequestStatus requestStatus;
}
