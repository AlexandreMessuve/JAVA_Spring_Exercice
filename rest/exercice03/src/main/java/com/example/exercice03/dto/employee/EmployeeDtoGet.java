package com.example.exercice03.dto.employee;

import com.example.exercice03.dto.person.PersonDtoGet;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EmployeeDtoGet extends PersonDtoGet {
    private LocalDate contractStart;

    private LocalDate contractEnd;

    private String occupation;

    private boolean admin;

    private double salary;
}
