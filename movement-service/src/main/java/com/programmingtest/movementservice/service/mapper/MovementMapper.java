package com.programmingtest.movementservice.service.mapper;

import com.programmingtest.movementservice.dto.MovementDto;
import com.programmingtest.movementservice.model.Movement;
import org.mapstruct.Mapper;

import java.util.List;

@Mapper(componentModel = "spring")
public interface MovementMapper {
    List<Movement> movementsDtoToMovements(List<MovementDto> movementsDto);

    Movement movementDtoToMovement(MovementDto accountDto);

    List<MovementDto> movementsToMovementsDto(List<Movement> accountDtos);

    MovementDto movementDtoToMovement(Movement account);
}
