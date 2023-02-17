package com.programmingtest.movementservice.service.strategy.impl;

import com.programmingtest.movementservice.model.Movement;
import com.programmingtest.movementservice.service.strategy.MovementStrategy;

import java.math.BigDecimal;

public class WithdrawalMovementStrategy implements MovementStrategy {
    @Override
    public void calculateBalance(Movement movement, BigDecimal lastBalance) {
        if(movement.getAmmount().compareTo(lastBalance) > 0) {
            BigDecimal finalBalance = lastBalance;
            movement.setBalance(finalBalance);
            movement.setState(false);
        } else {
            BigDecimal ammount = movement.getAmmount();
            BigDecimal finalBalance = lastBalance.subtract(ammount);
            movement.setBalance(finalBalance);
            movement.setState(true);
        }
    }
}
