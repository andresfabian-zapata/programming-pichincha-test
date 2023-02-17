package com.programmingtest.movementservice.repository;


import com.programmingtest.movementservice.model.Movement;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;
import java.util.Optional;

public interface MovementRepository extends JpaRepository<Movement, Long> {

    List<Movement> findByAccountNumber(String accountNumber);

    Optional<Movement> findFirstByAccountNumberOrderByIdDesc(String accountNumber);

}
