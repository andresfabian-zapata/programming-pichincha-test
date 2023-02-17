package com.programmingtest.movementservice.service;

import com.programmingtest.movementservice.model.AccountProxy;
import org.springframework.web.bind.annotation.GetMapping;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@FeignClient(name = "account-service", url = "localhost:8082")
public interface AccountServiceFeign {

    @GetMapping("/api/cuentas")
    List<AccountProxy> getAccountByAccountNumber(@RequestParam String number);
}
