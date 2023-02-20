package com.programmingtest.accountservice.controller;

import com.programmingtest.accountservice.dto.AccountGetResponse;
import com.programmingtest.accountservice.dto.AccountRequest;
import com.programmingtest.accountservice.dto.AccountUpdate;
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
    public List<AccountGetResponse> getAccounts(
            @RequestParam(name = "number", required = false) String number) {
        return accountService.getAccounts(number);
    }

    @PatchMapping("/{account_id}")
    public AccountUpdate patchAccount(@PathVariable Long account_id, @RequestBody AccountUpdate accountUpdate) {
        return accountService.patchAccountId(account_id, accountUpdate);
    }

    @PutMapping("/{account_id}")
    public AccountUpdate putClientId(@PathVariable Long account_id, @RequestBody AccountUpdate accountUpdate) {
        return  accountService.putAccountId(account_id, accountUpdate);
    }

    @DeleteMapping("/{account_id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public String deleteClientId(@PathVariable Long account_id) {
        accountService.deleteAccountId(account_id);
        return "Deleted OK";
    }

}
