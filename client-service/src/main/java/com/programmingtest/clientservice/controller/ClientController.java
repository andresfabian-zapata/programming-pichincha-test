package com.programmingtest.clientservice.controller;

import com.programmingtest.clientservice.dto.ClientDto;
import com.programmingtest.clientservice.dto.ClientRequest;
import com.programmingtest.clientservice.service.ClientService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/clientes")
@RequiredArgsConstructor
public class ClientController {

    private final ClientService clientService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addClients(@RequestBody ClientRequest clientRequest) {
        clientService.addClients(clientRequest);
        return "Clientes agregados";
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<ClientDto> getClients() {
        return clientService.getClients();
    }

    @GetMapping("/{client_id}")
    @ResponseStatus(HttpStatus.OK)
    public ClientDto getClientId(@PathVariable Long client_id) {
        return clientService.getClientId(client_id);
    }
}
