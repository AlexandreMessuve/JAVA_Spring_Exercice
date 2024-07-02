package org.exercice05_furniture.service;

import org.exercice05_furniture.dao.CartItemRepository;
import org.exercice05_furniture.model.CartItem;
import org.exercice05_furniture.model.Furniture;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.concurrent.atomic.AtomicReference;

@Service
public class CartItemService implements BaseService<CartItem> {
    private final CartItemRepository cartItemRepository;
    private final FurnitureService furnitureService;

    @Autowired
    public CartItemService(CartItemRepository cartItemRepository, FurnitureService furnitureService) {
        this.cartItemRepository = cartItemRepository;
        this.furnitureService = furnitureService;
    }

    @Override
    public void save(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void update(CartItem cartItem) {
        cartItemRepository.save(cartItem);
    }

    @Override
    public void delete(CartItem cartItem) {
        cartItemRepository.delete(cartItem);
    }

    @Override
    public CartItem findById(Long id) {
        return cartItemRepository.findById(id).orElse(null);
    }

    @Override
    public List<CartItem> findAll() {
        return cartItemRepository.findAll();
    }

    public CartItem findByFurnitureId(Long furnitureId) {
        Furniture furniture = furnitureService.findById(furnitureId);
        return cartItemRepository.findByFurnitureId(furniture);
    }

    public double totalPrice(){
        List<CartItem> cartItems = cartItemRepository.findAll();
        AtomicReference<Double> totalPrice = new AtomicReference<>((double) 0);
        cartItems.forEach(item -> {
            totalPrice.updateAndGet(v -> new Double((v + item.getQuantity() * item.getFurniture().getPrice())));
        });
        return totalPrice.get();
    }
    public void deleteAll(){
        cartItemRepository.deleteAll();
    }
}
