package com.example.exercice03.dto.candidate;

import com.example.exercice03.dto.person.PersonDtoGet;
import lombok.*;

import java.time.LocalDate;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class CandidateDtoGet extends PersonDtoGet {
    private int rating;
    private String skill;
    private String technicalArea;
    private LocalDate jobInterviewDateStr;
}
