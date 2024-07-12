package com.example.exercice03.entity;

import jakarta.persistence.*;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;
import java.util.List;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Employee extends Person {
    @Temporal(TemporalType.DATE)
    private LocalDate contractStart;
    @Temporal(TemporalType.DATE)
    private LocalDate contractEnd;

    private String occupation;

    private String password;

    private boolean admin;

    private double salary;

    @OneToMany(mappedBy = "employee")
    private List<Absence> absenceList;
    @OneToMany(mappedBy = "employee")
    private List<Vacancy> vacancyList;

}
