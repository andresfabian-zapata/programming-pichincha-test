package com.programmingtest.accountservice.service.mapper;

import com.programmingtest.accountservice.dto.AccountUpdate;
import com.programmingtest.accountservice.model.Account;
import org.mapstruct.*;

@Mapper(componentModel = "spring")
public interface AccountPatchMapper {

    @Mapping(target = "number", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "type", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "initial_balance", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "state", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    @Mapping(target = "client_id", nullValuePropertyMappingStrategy = NullValuePropertyMappingStrategy.IGNORE)
    void accountUpdateToAccount(AccountUpdate source, @MappingTarget Account target);
}
