package org.exercice05_furniture.dao;

import org.exercice05_furniture.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FurnitureRepository extends JpaRepository<Furniture, Long> {
}
