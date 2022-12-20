package com.herb.bankapp.dto.response;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountResponse {
    private int iban;
    private int number;
    private List<CardResponse> cards;
}
