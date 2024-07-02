package org.exercice05_furniture.controller;

import jakarta.servlet.http.HttpSession;
import org.exercice05_furniture.model.CartItem;
import org.exercice05_furniture.model.Furniture;
import org.exercice05_furniture.service.CartItemService;
import org.exercice05_furniture.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class CartItemController {
    private final CartItemService cartItemService;
    private final FurnitureService furnitureService;
    private final HttpSession session;

    public CartItemController(CartItemService cartItemService, FurnitureService furnitureService, HttpSession httpSession) {
        this.cartItemService = cartItemService;
        this.furnitureService = furnitureService;
        this.session = httpSession;
    }

    @GetMapping("/carts")
    public String carts(Model model) {
        List<CartItem> cartItems = cartItemService.findAll();
        model.addAttribute("cartItems", cartItems);
        cartSize();
        totalCartPrice();
        return "cart/list";
    }
    @GetMapping("/cart/add")
    public String addCartItem(@RequestParam(name = "furnitureId") Long furnitureId) {
        CartItem cartItem = cartItemService.findByFurnitureId(furnitureId);
        Furniture furniture = furnitureService.findById(furnitureId);
        if (furniture.getStock() > 0){
            if (cartItem == null) {
                cartItem = CartItem.builder()
                        .furniture(furniture)
                        .quantity(1)
                        .build();
                cartItemService.save(cartItem);
            }else{
                cartItem.setQuantity(cartItem.getQuantity() + 1);
                cartItemService.update(cartItem);
            }
            furniture.setStock(furniture.getStock() - 1);
            furnitureService.update(furniture);
        }
        return "redirect:/carts";
    }

    @GetMapping("/cart/remove/one")
    public String removeOneCartItem(@RequestParam(name = "id") Long id) {
        CartItem cartItem = cartItemService.findById(id);
        if (cartItem != null) {
            Furniture furniture = cartItem.getFurniture();
            if (cartItem.getQuantity() == 1) {
                cartItemService.delete(cartItem);
            } else {
                cartItem.setQuantity(cartItem.getQuantity() - 1);
                cartItemService.update(cartItem);
            }
            furniture.setStock(furniture.getStock() + 1);
            furnitureService.update(furniture);
        }
        return "redirect:/carts";
    }

    @GetMapping("/cart/remove")
    public String removeCartItem(@RequestParam(name = "id") Long id) {
        CartItem cartItem = cartItemService.findById(id);
        if (cartItem != null) {
            Furniture furniture = cartItem.getFurniture();
            furniture.setStock(cartItem.getQuantity() + furniture.getStock());
            cartItemService.delete(cartItem);
            furnitureService.update(furniture);
        }
        return "redirect:/carts";
    }

    @GetMapping("/cart/remove/all")
    public String removeAllCartItems() {
        List<CartItem> cartItemList = cartItemService.findAll();
        cartItemList.forEach(cartItem -> {
            Furniture furniture = cartItem.getFurniture();
            furniture.setStock(furniture.getStock() + cartItem.getQuantity());
            furnitureService.update(furniture);
        });
        cartItemService.deleteAll();
        totalCartPrice();
        cartSize();
        return "redirect:/";
    }

    public void totalCartPrice(){
        double totalPrice = cartItemService.totalPrice();
        session.setAttribute("totalCartPrice", totalPrice);
    }
    public void cartSize(){
        int size = cartItemService.findAll().size();
        session.setAttribute("cartSize", size);
    }
}
