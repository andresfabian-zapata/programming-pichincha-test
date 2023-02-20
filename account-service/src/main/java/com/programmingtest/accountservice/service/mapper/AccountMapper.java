package com.programmingtest.accountservice.service.mapper;


import com.programmingtest.accountservice.dto.AccountGetResponse;
import com.programmingtest.accountservice.dto.AccountPostDto;
import com.programmingtest.accountservice.dto.AccountUpdate;
import com.programmingtest.accountservice.model.Account;
import org.mapstruct.*;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AccountMapper {

    List<Account> accountsDtoToAccounts(List<AccountPostDto> accountDtos);

    Account accountPostDtoToAccount(AccountPostDto accountPostDto);

    List<AccountGetResponse> accountsToAccountsGetResponse(List<Account> accounts);

    AccountGetResponse accountToAccountGetResponseDto(Account account);

    void accountUpdateToAccount(AccountUpdate dto, @MappingTarget Account target);

    AccountUpdate accountToAccountUpdate(Account account);

}
