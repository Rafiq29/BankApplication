package com.herb.bankapp.dto.request;

import com.herb.bankapp.entity.enums.CardType;
import com.herb.bankapp.entity.enums.Currency;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardAddRequestDTO {
    private int number;
    private LocalDate exp_date;
    private int cvv;
    private Currency currency;
    private String holder_firstname;
    private String holder_lastname;
    private CardType type;
}
