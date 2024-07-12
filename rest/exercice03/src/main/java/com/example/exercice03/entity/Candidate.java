package com.example.exercice03.entity;

import jakarta.persistence.Entity;
import jakarta.persistence.Temporal;
import jakarta.persistence.TemporalType;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDateTime;

@EqualsAndHashCode(callSuper = true)
@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class Candidate extends Person {
    private int rating;
    private String skill;
    private String technicalArea;

    @Temporal(TemporalType.TIMESTAMP)
    private LocalDateTime jobInterviewDate;
}
