package com.herb.bankapp.dto.request;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardDepositRequestDTO {
    private long source_id;
    private long destination_id;
    private double balance;
}
