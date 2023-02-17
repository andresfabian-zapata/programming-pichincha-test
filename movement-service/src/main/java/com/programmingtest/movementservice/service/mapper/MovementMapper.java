package com.programmingtest.movementservice.service.mapper;

import com.programmingtest.movementservice.dto.MovementGetDto;
import com.programmingtest.movementservice.dto.MovementPostDto;
import com.programmingtest.movementservice.model.Movement;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    List<Movement> movementsPostDtoToMovements(List<MovementPostDto> movementsDto);

    @Mapping(source="account_number", target = "accountNumber")
    @Mapping(source="date", target = "date", dateFormat = "yyyy-MM-dd")
    Movement movementPostDtoToMovement(MovementPostDto accountDto);

    List<MovementGetDto> movementsToMovementGetDtos(List<Movement> movements);

    @Mapping(source="accountNumber", target= "account_number")
    @Mapping(source="date", target = "date", dateFormat = "yyyy-MM-dd")
    MovementGetDto movementDtoToMovement(Movement account);
}
