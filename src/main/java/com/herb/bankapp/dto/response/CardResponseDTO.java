package com.herb.bankapp.dto.response;

import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@ToString
public class CardResponse {
    private long id;
    private int number;
    private LocalDate exp_date;
    private String holder_name;
}
