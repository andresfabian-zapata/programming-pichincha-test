package com.programmingtest.accountservice.dto;

import com.programmingtest.accountservice.model.ClientProxy;
import com.programmingtest.accountservice.service.AccountService;
import jakarta.persistence.PostLoad;
import jakarta.persistence.Transient;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class AccountPostDto {

    private String number;
    private String type;
    private BigDecimal initial_balance;
    private Boolean state;
    private Long client_id;
    private ClientProxy client;

}
