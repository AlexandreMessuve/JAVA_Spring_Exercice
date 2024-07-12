package com.example.exercice03.dto.absence;

import jakarta.validation.constraints.Pattern;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class AbsenceDtoPost {
    @Pattern(regexp = "([0-9]+(-[0-9]+)+)", message = "Date is not valid")
    private String dateStr;
    private int employee;
}
