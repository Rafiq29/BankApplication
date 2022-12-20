package com.herb.bankapp.entity;

import com.herb.bankapp.entity.enums.RequestStatus;
import lombok.*;

import javax.persistence.*;
import java.util.List;

//@Data
@Entity
//@Builder
@NoArgsConstructor
//@AllArgsConstructor
@Table(name = "accounts")
@Setter
@Getter
public class Account {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;
    private int number;
    private int iban;
    private String swift;
    @Enumerated(EnumType.STRING)
    private RequestStatus requestStatus = RequestStatus.WAITING;
    @OneToOne
    private User user;
    @OneToMany(mappedBy = "account", fetch = FetchType.EAGER)
    private List<Card> cards;
    @Column(columnDefinition = "boolean default true")
    private Boolean status = true;

    @Override
    public String toString() {
        return "Account{" +
                "id=" + id +
                ", number=" + number +
                ", iban=" + iban +
                ", swift='" + swift + '\'' +
                ", requestStatus=" + requestStatus +
                ", status=" + status +
                '}';
    }
}
