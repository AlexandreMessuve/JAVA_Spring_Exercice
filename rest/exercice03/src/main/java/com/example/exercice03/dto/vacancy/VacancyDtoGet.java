package com.example.exercice03.dto.vacancy;

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
public class VacancyDtoGet {
    private int id;
    private LocalDate startDate;
    private LocalDate endDate;
    private Employee employee;
}
