package com.programmingtest.movementservice.service;

import com.programmingtest.movementservice.dto.MovementDto;
import com.programmingtest.movementservice.dto.MovementRequest;
import com.programmingtest.movementservice.repository.MovementRepository;
import com.programmingtest.movementservice.service.mapper.MovementMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;

    public void addMovements (MovementRequest movementRequest) {
        movementRepository.saveAll(movementMapper.movementsDtoToMovements(movementRequest.getMovements()));
    }

    public List<MovementDto> getMovements () {
        return movementMapper.movementsToMovementsDto(movementRepository.findAll());
    }
}
