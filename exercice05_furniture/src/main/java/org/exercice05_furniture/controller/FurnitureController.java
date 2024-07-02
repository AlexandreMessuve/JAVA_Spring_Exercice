package org.exercice05_furniture.controller;

import org.exercice05_furniture.model.CartItem;
import org.exercice05_furniture.model.Furniture;
import org.exercice05_furniture.service.CartItemService;
import org.exercice05_furniture.service.FurnitureService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
public class FurnitureController {
    private final FurnitureService furnitureService;
    private final CartItemService cartItemService;

    public FurnitureController(FurnitureService furnitureService, CartItemService cartItemService) {
        this.furnitureService = furnitureService;
        this.cartItemService = cartItemService;
    }

    @GetMapping("/")
    public String home(Model model) {
        List<Furniture> furnitureList = furnitureService.findAll();
        model.addAttribute("furnitureList", furnitureList);
        return "home";
    }

    @GetMapping("/add")
    public String addForm(Model model) {
        model.addAttribute("furniture", new Furniture());
        return "furniture/form";
    }

    @PostMapping("/add")
    public String add(@ModelAttribute("furniture") Furniture furniture) {
        furnitureService.save(furniture);
        return "redirect:/";
    }

    @GetMapping("/update")
    public String updateForm(@RequestParam(name = "id") Long id, Model model) {
        Furniture furniture = furnitureService.findById(id);
        model.addAttribute("furniture", furniture);
        return "furniture/form";
    }
    @GetMapping("/detail")
    public String detail(@RequestParam(name = "id") Long id, Model model) {
        Furniture furniture = furnitureService.findById(id);
        model.addAttribute("furniture", furniture);
        return "furniture/detail";
    }

    @GetMapping("/delete")
    public String delete(@RequestParam(name = "id") Long id) {
        Furniture furniture = furnitureService.findById(id);
        CartItem cartItem = cartItemService.findByFurnitureId(id);
        if (cartItem != null) {
            cartItemService.delete(cartItem);
        }
        furnitureService.delete(furniture);
        return "redirect:/";
    }
}
