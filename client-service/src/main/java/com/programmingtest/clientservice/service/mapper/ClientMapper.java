package com.programmingtest.clientservice.service.mapper;

import com.programmingtest.clientservice.dto.ClientDto;
import com.programmingtest.clientservice.model.Client;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    List<Client> clientsDtoToClients(List<ClientDto> clientDtos);

    Client clientDtoToClient(ClientDto clientDto);

    List<ClientDto> clientsToClientsDto (List<Client> clients);

    ClientDto clientToClientDto (Client client);


}
