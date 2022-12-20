package com.herb.bankapp.entity;

import com.herb.bankapp.entity.enums.CardType;
import com.herb.bankapp.entity.enums.Currency;
import com.herb.bankapp.entity.enums.RequestStatus;
import lombok.*;

import javax.persistence.*;
import java.time.LocalDate;

//@Data
@Entity
//@Builder
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "cards")
@Getter
@Setter
public class Card {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private LocalDate exp_date;
    private int cvv;
    @Enumerated(EnumType.STRING)
    private Currency currency;
    @Enumerated(EnumType.STRING)
    private CardType type;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus = RequestStatus.WAITING;
    @Column(columnDefinition = "Decimal(10,2) default '0.0'")
    private double balance = 0.0;
    @ManyToOne
    @JoinColumn(name = "account_id")
    private Account account;
    @Column(columnDefinition = "boolean default true")
    private Boolean status = true;

    @Override
    public String toString() {
        return "Card{" +
                "id=" + id +
                ", number=" + number +
                ", exp_date=" + exp_date +
                ", cvv=" + cvv +
                ", currency=" + currency +
                ", type=" + type +
                ", requestStatus=" + requestStatus +
                ", balance=" + balance +
                ", status=" + status +
                '}';
    }
}
