package com.programmingtest.clientservice.service;

import com.programmingtest.clientservice.dto.ClientDto;
import com.programmingtest.clientservice.dto.ClientPatchRequest;
import com.programmingtest.clientservice.dto.ClientRequest;
import com.programmingtest.clientservice.exception.ResourceNotFoundException;
import com.programmingtest.clientservice.model.Client;
import com.programmingtest.clientservice.repository.ClientRepository;
import com.programmingtest.clientservice.service.mapper.ClientMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.BeanWrapper;
import org.springframework.beans.BeanWrapperImpl;
import org.springframework.stereotype.Service;

import java.util.HashSet;
import java.util.List;
import java.util.Set;

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

    public ClientDto patchClientId(Long id, ClientPatchRequest request) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
        BeanUtils.copyProperties(request, existingClient, getNullPropertyNames(request));
        return clientMapper.clientToClientDto(clientRepository.save(existingClient));
    }

    private static String[] getNullPropertyNames(Object source) {
        final BeanWrapper src = new BeanWrapperImpl(source);
        java.beans.PropertyDescriptor[] pds = src.getPropertyDescriptors();
        Set<String> emptyNames = new HashSet<>();
        for (java.beans.PropertyDescriptor pd : pds) {
            Object srcValue = src.getPropertyValue(pd.getName());
            if (srcValue == null) {
                emptyNames.add(pd.getName());
            }
        }
        String[] result = new String[emptyNames.size()];
        return emptyNames.toArray(result);
    }

    public ClientDto putClientId(Long id, ClientPatchRequest request) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
        BeanUtils.copyProperties(request, existingClient);
        return clientMapper.clientToClientDto(clientRepository.save(existingClient));
    }

    public void deleteClientId(Long id) {
        Client existingClient = clientRepository.findById(id)
                .orElseThrow(() -> new ResourceNotFoundException("Client", "id", id));
        clientRepository.delete(existingClient);
    }

}
