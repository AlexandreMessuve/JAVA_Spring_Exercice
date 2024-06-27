package org.tp_kitchen.model;

import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;
@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Category {
    private long id;

    @NotNull(message = "Name is required")
    @Size(min = 3, message = "Min 3 characters")
    private String name;

    @NotNull(message = "Description is required")
    @Size(min = 10, message = "Min 10 characters")
    private String description;
}
