package com.programmingtest.movementservice.dto;

import com.programmingtest.movementservice.model.enums.MovementType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementGetDto {

    private Long id;
    private String account_number;
    private String date;
    private MovementType type;
    private BigDecimal ammount;
    private BigDecimal balance;

}
