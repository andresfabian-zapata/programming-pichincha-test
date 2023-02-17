package com.programmingtest.movementservice.controller;

import com.programmingtest.movementservice.dto.MovementGetDto;
import com.programmingtest.movementservice.dto.MovementPostDto;
import com.programmingtest.movementservice.dto.MovementPostRequest;
import com.programmingtest.movementservice.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/movimientos")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addMovements(@RequestBody MovementPostRequest movementPostRequest) {
        movementService.addMovements(movementPostRequest);
        return "Movimientos agregados: " + movementPostRequest.getMovements().size();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovementGetDto> getMovements(
            @RequestParam(name = "account_number", required = false) String accountNumber) {
        return movementService.getMovements(accountNumber);
    }
}
