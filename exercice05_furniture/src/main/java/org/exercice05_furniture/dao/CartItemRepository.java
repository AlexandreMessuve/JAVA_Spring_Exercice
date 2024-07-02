package org.exercice05_furniture.dao;

import org.exercice05_furniture.model.CartItem;
import org.exercice05_furniture.model.Furniture;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface CartItemRepository extends JpaRepository<CartItem, Long> {
    @Query(value = "SELECT c FROM CartItem as c WHERE c.furniture = ?1")
    CartItem findByFurnitureId(Furniture furniture);
}
