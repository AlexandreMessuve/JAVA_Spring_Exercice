package org.exercice03.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import jakarta.validation.constraints.*;
import java.time.LocalDate;
import java.util.UUID;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Student {
    private UUID id;

    @NotNull(message = "Lastname is required !")
    @NotBlank()
    @Size(min = 2, message = "Min 2 characters !")
    private String lastname;

    @NotNull(message = "Firstname is required !")
    @NotBlank()
    @Size(min = 2, message = "Min 2 characters !")
    private String firstname;

    @NotNull(message = "Email is required !")
    @NotBlank()
    @Email(regexp = "^(?=.{1,64}@)[A-Za-z0-9_-]+(\\.[A-Za-z0-9_-]+)*@"
            + "[^-][A-Za-z0-9-]+(\\.[A-Za-z0-9-]+)*(\\.[A-Za-z]{2,})$", message = "Email is invalid")
    private String email;

    @NotNull(message = "Birthdate is require")
    @PastOrPresent(message = "Your birth date is not valid")
    private LocalDate birthDate;

    public int getAge(){
        return LocalDate.now().getYear() - birthDate.getYear();
    }
}
