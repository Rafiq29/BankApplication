package com.herb.bankapp.dto.request;

import lombok.*;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class AccountRequest {
    private int number;
    private int iban;
    private String swift;
    private List<Integer> card_num;
}
