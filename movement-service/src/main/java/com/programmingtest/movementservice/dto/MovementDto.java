package com.programmingtest.movementservice.dto;


import com.programmingtest.movementservice.model.enums.MovementType;
import jakarta.persistence.EnumType;
import jakarta.persistence.Enumerated;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.math.BigDecimal;
import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class MovementDto {

    private Long id;
    private Date date;
    private MovementType type;
    private BigDecimal ammount;
    private BigDecimal balance;

}
