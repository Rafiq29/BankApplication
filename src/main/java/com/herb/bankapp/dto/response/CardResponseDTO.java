package com.herb.bankapp.dto.response;

import com.fasterxml.jackson.annotation.JsonFormat;
import com.herb.bankapp.entity.enums.CardType;
import com.herb.bankapp.entity.enums.RequestStatus;
import lombok.*;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class CardResponseDTO {
    private int number;
    @JsonFormat(pattern="yyyy-MM-dd")
    private LocalDate exp_date;
    private double balance;
    private CardType type;
    private RequestStatus requestStatus;
}
