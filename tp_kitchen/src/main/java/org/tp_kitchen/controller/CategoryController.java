package org.tp_kitchen.controller;


import jakarta.validation.Valid;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.tp_kitchen.model.Category;
import org.tp_kitchen.service.CategoryService;
import org.tp_kitchen.service.RecipeService;

import java.util.List;

@Controller
public class CategoryController {
    private final CategoryService categoryService;
    private final RecipeService recipeService;

    public CategoryController(CategoryService categoryService, RecipeService recipeService) {
        this.categoryService = categoryService;
        this.recipeService = recipeService;
    }

    @GetMapping("/categories")
    public String listCategories(Model model) {
        List<Category> categories = categoryService.getAllCategories();
        model.addAttribute("categories", categories);
        return "category/list";
    }

    @GetMapping("/category/detail")
    public String detailCategory(@RequestParam Long id, Model model) {
        Category category = categoryService.getCategoryById(id);
        model.addAttribute("category", category);
        model.addAttribute("recipes", recipeService.getRecipesByCategory(category));
        return "category/detail";
    }
    @GetMapping("/category/add")
    public String addCategory(Model model) {
        model.addAttribute("category", new Category());
        return "category/form";
    }
    @GetMapping("/category/edit")
    public String addCategory(@RequestParam(name = "id")long id, Model model) {
        model.addAttribute("category", categoryService.getCategoryById(id));
        return "category/form";
    }
    @GetMapping("/category/delete")
    public String deleteCategory(@RequestParam long id) {
        categoryService.deleteCategory(id);
        return "redirect:/categories";
    }

    @PostMapping("/category/form")
    public String formCategory(@Valid @ModelAttribute("category") Category category, BindingResult result) {
        if (result.hasErrors()) {
            return "category/form";
        }
        if (category.getId() != 0) {
            categoryService.updateCategory(category.getId(), category);
        }else{
            categoryService.addCategory(category);
        }

        return "redirect:/categories";
    }
}
