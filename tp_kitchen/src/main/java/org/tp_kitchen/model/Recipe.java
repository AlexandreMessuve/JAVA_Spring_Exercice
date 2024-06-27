package org.tp_kitchen.model;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.*;

import java.util.List;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class Recipe {
    private long id;

    @NotNull(message = "Name is required")
    @NotBlank
    @Size(min = 2, max = 50, message = "Min 2 & Max 50 characters")
    private String name;

    @NotNull(message = "Ingredients is required")
    private List<String> ingredients;

    @NotNull(message = "Step is required")
    private List<String> steps;

    private Category category;

    @NotNull(message = "Category is required")
    private Long categoryId;
}
