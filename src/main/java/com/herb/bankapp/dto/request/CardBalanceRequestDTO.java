package com.herb.bankapp.dto.request;

import io.swagger.annotations.ApiModelProperty;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class CardBalanceRequestDTO {
    @ApiModelProperty(notes = "Card From ID")
    private long source_id;
    @ApiModelProperty(notes = "Card To ID")
    private long destination_id;
    @ApiModelProperty(notes = "Card Balance")
    private double balance;
}
