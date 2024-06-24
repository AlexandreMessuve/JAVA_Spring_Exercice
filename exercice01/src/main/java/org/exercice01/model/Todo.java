package org.exercice01.model;

import lombok.*;

@Builder
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Todo {
    String name, description;
    boolean completed;
}
