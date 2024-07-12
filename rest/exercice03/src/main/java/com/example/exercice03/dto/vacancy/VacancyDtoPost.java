package com.example.exercice03.dto.vacancy;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class VacancyDtoPost {
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)", message = "Start date is not valid")
    private String startDateStr;
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)", message = "End date is not valid")
    private String endDateStr;
    private int employee;
}
