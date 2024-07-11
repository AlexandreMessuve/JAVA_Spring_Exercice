package com.example.exercice03.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Employee extends Person {
    @Temporal(TemporalType.DATE)
    private LocalDate contractStart;
    @Temporal(TemporalType.DATE)
    private LocalDate contractEnd;

    private String occupation;

    private String password;

    private boolean admin;

    private double salary;
}
