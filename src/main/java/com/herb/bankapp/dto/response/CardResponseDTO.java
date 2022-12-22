package com.herb.bankapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herb.bankapp.entity.enums.CardType;
import com.herb.bankapp.entity.enums.RequestStatus;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDTO {
    @ApiModelProperty(notes = "Card number")
    private int number;
    @ApiModelProperty(notes = "Card Expire Date")
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate exp_date;
    @ApiModelProperty(notes = "Card Balance")
    private double balance;
    @ApiModelProperty(notes = "Card Type")
    private CardType type;
    @ApiModelProperty(notes = "Card Request Status (REJECTED, WAITING, ACCEPTED)")
    private RequestStatus requestStatus;
}
