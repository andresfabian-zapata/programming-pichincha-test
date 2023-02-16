package com.programmingtest.movementservice.repository;


import com.programmingtest.movementservice.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MovementRepository extends JpaRepository<Movement, Long> {
}
