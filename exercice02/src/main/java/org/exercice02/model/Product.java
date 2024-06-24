package org.exercice02.model;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

import java.util.UUID;

@Data
@AllArgsConstructor
@Builder
public class Product {
    private UUID id;
    private String name;
    private Category category;
    private double price;
}
