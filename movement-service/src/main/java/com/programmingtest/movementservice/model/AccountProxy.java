package com.programmingtest.movementservice.model;


import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.math.BigDecimal;

@Setter
@Getter
@NoArgsConstructor
@AllArgsConstructor
public class AccountProxy {
    private Long id;
    private String number;
    private String type;
    private BigDecimal initial_balance;
    private Boolean state;
    private Long client_id;
}
