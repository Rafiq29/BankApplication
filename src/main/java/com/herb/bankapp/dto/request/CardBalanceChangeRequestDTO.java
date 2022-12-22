package com.herb.bankapp.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardBalanceChangeRequestDTO {
    @ApiModelProperty(notes = "Card ID")
    private long id;
    @ApiModelProperty(notes = "Card Balance")
    private double balance;
}
