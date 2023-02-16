package com.programmingtest.accountservice.service.mapper;


import com.programmingtest.accountservice.dto.AccountGetResponse;
import com.programmingtest.accountservice.dto.AccountPostDto;
import com.programmingtest.accountservice.model.Account;
import com.programmingtest.accountservice.service.AccountService;
import com.programmingtest.accountservice.service.ClientServiceFeign;
import lombok.RequiredArgsConstructor;
import org.mapstruct.AfterMapping;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    List<Account> accountsDtoToAccounts(List<AccountPostDto> accountDtos);

    Account accountPostDtoToAccount(AccountPostDto accountPostDto);

    List<AccountGetResponse> accountsToAccountsGetResponse(List<Account> accounts);

    AccountGetResponse accountToAccountGetResponseDto(Account account);

}
