package com.herb.bankapp.dto.request;

import lombok.*;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class AccountRequestDTO {
    private int number;
    private int iban;
    private String swift;
    private String holder_firstname;
    private String holder_lastname;
}
