package com.example.exercice03.dto.person;

import jakarta.validation.constraints.Max;
import jakarta.validation.constraints.Pattern;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public abstract class PersonDtoPost {
    @Size(max = 50, message = "Max size of firstname is 50")
    private String firstname;
    @Size(max = 50, message = "Max size of lastname is 50")
    private String lastname;

    @Pattern(regexp = "^[\\w-.]+@([\\w-]+\\.)+[\\w-]{2,4}$", message = "Email is not valid")
    private String email;

    @Pattern(regexp = "^(?:(?:\\+|00)33[\\s.-]{0,3}(?:\\(0\\)[\\s.-]{0,3})?|0)[1-9](?:(?:[\\s.-]?\\d{2}){4}|\\d{2}(?:[\\s.-]?\\d{3}){2})$", message = "Phone number is not valid")
    private String phone;

    @Pattern(regexp = "([0-9]+(-[0-9]+)+)", message = "Birth date is not valid")
    private String birthdayStr;


    private String address;

    private String observation;
}
