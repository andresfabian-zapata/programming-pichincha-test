package com.programmingtest.accountservice.dto;


import com.programmingtest.accountservice.model.ClientProxy;
import com.programmingtest.accountservice.model.enums.AccountType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountGetResponse {

    private Long id;
    private String number;
    private AccountType type;
    private BigDecimal initial_balance;
    private Boolean state;
    private Long client_id;
    private ClientProxy client;

}
