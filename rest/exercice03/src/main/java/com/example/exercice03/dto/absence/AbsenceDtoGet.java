package com.example.exercice03.dto.absence;

import com.example.exercice03.entity.Employee;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbsenceDtoGet {
    private int id;
    private LocalDate date;
    private Employee employee;
}
