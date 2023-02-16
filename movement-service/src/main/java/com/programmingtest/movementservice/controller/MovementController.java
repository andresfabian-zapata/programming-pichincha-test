package com.programmingtest.movementservice.controller;

import com.programmingtest.movementservice.dto.MovementDto;
import com.programmingtest.movementservice.dto.MovementRequest;
import com.programmingtest.movementservice.service.MovementService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController
@RequestMapping("/api/cuentas")
@RequiredArgsConstructor
public class MovementController {

    private final MovementService movementService;

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public String addMovements(@RequestBody MovementRequest movementRequest) {
        movementService.addMovements(movementRequest);
        return "Movimientos agregados: " + movementRequest.getMovements().size();
    }

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<MovementDto> getMovements() {
        return movementService.getMovements();
    }
}
