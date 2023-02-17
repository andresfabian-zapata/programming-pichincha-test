package com.programmingtest.movementservice.service.strategy;

import com.programmingtest.movementservice.model.Movement;

import java.math.BigDecimal;
import java.util.Optional;

public interface MovementStrategy {
    void calculateBalance(Movement movement, BigDecimal lastBalance);
}