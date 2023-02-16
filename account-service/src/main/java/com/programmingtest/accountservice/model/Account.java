package com.programmingtest.accountservice.model;

import com.programmingtest.accountservice.model.enums.AccountType;
import jakarta.persistence.*;
import lombok.*;

import java.math.BigDecimal;

@Entity
@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class Account {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String number;
    @Enumerated(EnumType.STRING)
    private AccountType type;
    private BigDecimal initial_balance;
    private Boolean state;
    private Long client_id;

}
