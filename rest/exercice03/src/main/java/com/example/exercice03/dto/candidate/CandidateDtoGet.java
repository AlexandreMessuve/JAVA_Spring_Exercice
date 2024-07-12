package com.example.exercice03.dto.candidate;

import com.example.exercice03.dto.person.PersonDtoGet;
import lombok.*;
import lombok.experimental.SuperBuilder;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CandidateDtoGet extends PersonDtoGet {
    private int rating;
    private String skill;
    private String technicalArea;
    private LocalDate jobInterviewDateStr;
}
