package com.example.exercice03.dto.employee;

import com.example.exercice03.dto.person.PersonDtoPost;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class EmployeeDtoPost extends PersonDtoPost {

    @Pattern(regexp = "([0-9]+(-[0-9]+)+)", message = "Date of contract start is not valid")
    private String contractStartStr;

    @Pattern(regexp = "([0-9]+(-[0-9]+)+)", message = "Date of contract end is not valid")
    private String contractEndStr;

    private String occupation;

    private String password;

    private boolean admin;

    private double salary;
}
