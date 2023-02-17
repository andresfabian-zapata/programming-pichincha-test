package com.programmingtest.movementservice.service;

import com.programmingtest.movementservice.dto.MovementGetDto;
import com.programmingtest.movementservice.dto.MovementPostDto;
import com.programmingtest.movementservice.dto.MovementPostRequest;
import com.programmingtest.movementservice.model.AccountProxy;
import com.programmingtest.movementservice.model.Movement;
import com.programmingtest.movementservice.model.enums.MovementType;
import com.programmingtest.movementservice.repository.MovementRepository;
import com.programmingtest.movementservice.service.mapper.MovementMapper;
import com.programmingtest.movementservice.service.strategy.MovementStrategy;
import com.programmingtest.movementservice.service.strategy.impl.DepositMovementStrategy;
import com.programmingtest.movementservice.service.strategy.impl.WithdrawalMovementStrategy;
import io.micrometer.common.util.StringUtils;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class MovementService {

    private final MovementRepository movementRepository;
    private final MovementMapper movementMapper;
    private final AccountServiceFeign accountServiceFeign;

    public void addMovements(MovementPostRequest movementPostRequest) {
        List<Movement> movements = setBalances(movementMapper.movementsPostDtoToMovements(movementPostRequest.getMovements()));
        movementRepository.saveAll(movements);
    }

    private List<Movement> setBalances(List<Movement> movements) {
        for (Movement movement : movements) {
            BigDecimal lastBalance = findLastBalance(movement.getAccountNumber());
            MovementStrategy movementStrategy = createMovementStrategy(movement.getType());
            if (movementStrategy != null) {
                movementStrategy.calculateBalance(movement, lastBalance);
            }
        }
        return movements;
    }

    public List<MovementGetDto> getMovements(String accountNumber) {
        List<Movement> movements;
        if (StringUtils.isEmpty(accountNumber)) {
            movements = movementRepository.findAll();
        } else {
            movements = movementRepository.findByAccountNumber(accountNumber);
        }
        return movementMapper.movementsToMovementGetDtos(movements);
    }

    public AccountProxy getAccountByAccountNumber(String accountNumber) {
        if (StringUtils.isNotEmpty(accountNumber)) {
            return accountServiceFeign.getAccountByAccountNumber(accountNumber).get(0);
        }
        return null;
    }

    private BigDecimal findLastBalance(String accountNumber) {
        Optional<Movement> lastMovement = movementRepository.findFirstByAccountNumberOrderByIdDesc(accountNumber);
        return lastMovement.map(Movement::getBalance).orElseGet(() -> getInitialBalance(accountNumber));
    }

    private BigDecimal getInitialBalance(String accountNumber) {
        return getAccountByAccountNumber(accountNumber).getInitial_balance();
    }

    private MovementStrategy createMovementStrategy(MovementType type) {
        switch (type) {
            case DEPOSIT:
                return new DepositMovementStrategy();
            case WITHDRAWAL:
                return new WithdrawalMovementStrategy();
            default:
                return null;
        }
    }
}
