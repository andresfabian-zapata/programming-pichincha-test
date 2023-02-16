package com.programmingtest.accountservice.controller;

import com.programmingtest.accountservice.dto.AccountGetResponse;
import com.programmingtest.accountservice.dto.AccountRequest;
import com.programmingtest.accountservice.service.AccountService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class AccountController {

    private final AccountService accountService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addAccounts(@RequestBody AccountRequest accountRequest) throws Exception {
        accountService.addAccounts(accountRequest);
        return "Cuentas agregadas: " + accountRequest.getAccounts().size();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<AccountGetResponse> getAccounts() {
        return accountService.getAccounts();
    }


}
