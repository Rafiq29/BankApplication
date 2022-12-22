package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.CardType;
import com.herb.bankapp.entity.enums.Currency;
import io.swagger.annotations.ApiModelProperty;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardAddRequestDTO {
    @ApiModelProperty(notes = "Card Number")
    private int number;
    @ApiModelProperty(notes = "Card Expire Date (Must be in \"yyyy-mm-dd\" form)")
    private LocalDate exp_date;
    @ApiModelProperty(notes = "Card CVV Number")
    private int cvv;
    @ApiModelProperty(notes = "Card Currency (AZN, USD, EUR)")
    private Currency currency;
    @ApiModelProperty(notes = "Card Holder First Name")
    private String holder_firstname;
    @ApiModelProperty(notes = "Card Holder Last Name")
    private String holder_lastname;
    @ApiModelProperty(notes = "Card Type (DEBIT, CREDIT)")
    private CardType type;
}
