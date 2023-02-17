package com.programmingtest.accountservice.service;

import com.programmingtest.accountservice.dto.AccountGetResponse;
import com.programmingtest.accountservice.dto.AccountPostDto;
import com.programmingtest.accountservice.dto.AccountRequest;
import com.programmingtest.accountservice.model.Account;
import com.programmingtest.accountservice.model.ClientProxy;
import com.programmingtest.accountservice.repository.AccountRepository;
import com.programmingtest.accountservice.service.mapper.AccountMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class AccountService {

    private final AccountRepository accountRepository;
    private final AccountMapper accountMapper;

    private final ClientServiceFeign clientFeignClient;

    public void addAccounts (AccountRequest accountRequest) throws Exception {
        List<Long> listClientId = accountRequest.getAccounts().stream().map(AccountPostDto::getClient_id).collect(Collectors.toList());
        if(validateIds(listClientId)) {
            accountRepository.saveAll(accountMapper.accountsDtoToAccounts(accountRequest.getAccounts()));
        } else {
            throw new Exception("No existen todos los ID que se desean insertar");
        }
    }

    public Boolean validateIds(List<Long> listClientId) {
        for (Long clientId : listClientId) {
            ClientProxy client = getClientById(clientId);
            if (client == null) {
                return false;
            }
        }
        return true;
    }

    public List<AccountGetResponse> getAccounts(String accountNumber) {
        if (accountNumber == null || accountNumber.isEmpty()) {
            return setClientInformation(accountMapper.accountsToAccountsGetResponse(accountRepository.findAll()));
        }

        Account account = accountRepository.findByNumber(accountNumber);
        if (account == null) {
            return new ArrayList<>();
        }
        return setClientInformation(accountMapper.accountsToAccountsGetResponse(Arrays.asList(account)));
    }

    private List<AccountGetResponse> setClientInformation(List<AccountGetResponse> accountGetResponses) {
        for (AccountGetResponse accountGetResponse : accountGetResponses) {
            ClientProxy clientProxy = getClientById(accountGetResponse.getClient_id());
            accountGetResponse.setClient(clientProxy);
        }
        return accountGetResponses;
    }

    public ClientProxy getClientById(Long id) {
        if(id != null){
            return clientFeignClient.getClientById(id);
        }
        return null;
    }

}


