package com.herb.bankapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardBalanceChangeRequestDTO {
    private long id;
    private double balance;
}
