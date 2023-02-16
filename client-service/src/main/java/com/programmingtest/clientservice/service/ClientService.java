package com.programmingtest.clientservice.service;

import com.programmingtest.clientservice.dto.ClientDto;
import com.programmingtest.clientservice.dto.ClientRequest;
import com.programmingtest.clientservice.repository.ClientRepository;
import com.programmingtest.clientservice.service.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ClientService {

    private final ClientRepository clientRepository;
    private final ClientMapper clientMapper;

    public void addClients (ClientRequest clientRequest) {
        clientRepository.saveAll(clientMapper.clientsDtoToClients(clientRequest.getClients()));
    }

    public List<ClientDto> getClients () {

        return clientMapper.clientsToClientsDto(clientRepository.findAll());
    }

    public ClientDto getClientId (Long id) {
        return clientMapper.clientToClientDto(clientRepository.getById(id));
    }


}
