package com.example.exercice03.dto.candidate;

import com.example.exercice03.dto.person.PersonDtoPost;
import jakarta.validation.constraints.Pattern;
import lombok.*;
import lombok.experimental.SuperBuilder;

@EqualsAndHashCode(callSuper = true)
@Data
@NoArgsConstructor
@AllArgsConstructor
@SuperBuilder
public class CandidateDtoPost extends PersonDtoPost {
    private int rating;
    private String skill;
    private String technicalArea;

    @Pattern(regexp = "\\d{4}-[01]\\d-[0-3]\\dT[0-2]\\d:[0-5]\\d:[0-5]\\d(?:\\.\\d+)?Z?")
    private String jobInterviewDateStr;
}
