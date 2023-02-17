package com.programmingtest.movementservice.service.strategy.impl;

import com.programmingtest.movementservice.model.Movement;
import com.programmingtest.movementservice.service.strategy.MovementStrategy;

import java.math.BigDecimal;
import java.util.Optional;

public class DepositMovementStrategy implements MovementStrategy {
    @Override
    public void calculateBalance(Movement movement, BigDecimal lastBalance) {
        BigDecimal ammount = movement.getAmmount();
        BigDecimal finalBalance = lastBalance.add(ammount);
        movement.setBalance(finalBalance);
        movement.setState(true);
    }
}
