package com.programmingtest.accountservice.service;

import com.programmingtest.accountservice.model.ClientProxy;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

@FeignClient(name = "client-service", url = "localhost:8081")
public interface ClientServiceFeign {

    @GetMapping("/api/clientes/{id}")
    ClientProxy getClientById(@PathVariable Long id);
}
