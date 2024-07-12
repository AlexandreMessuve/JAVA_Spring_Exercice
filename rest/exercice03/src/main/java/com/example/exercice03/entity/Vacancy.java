package com.example.exercice03.entity;

import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Vacancy {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    @Temporal(TemporalType.DATE)
    private LocalDate startDate;
    @Temporal(TemporalType.DATE)
    private LocalDate endDate;

    @ManyToOne(fetch = FetchType.LAZY, cascade = CascadeType.ALL)
    private Employee employee;
}
