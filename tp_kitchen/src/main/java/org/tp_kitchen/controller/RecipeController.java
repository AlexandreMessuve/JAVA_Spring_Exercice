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
import org.tp_kitchen.model.Recipe;
import org.tp_kitchen.service.CategoryService;
import org.tp_kitchen.service.RecipeService;

import java.util.ArrayList;
import java.util.List;

@Controller
public class RecipeController {
    private final RecipeService recipeService;
    private final CategoryService categoryService;

    public RecipeController(RecipeService recipeService, CategoryService categoryService) {
        this.recipeService = recipeService;
        this.categoryService = categoryService;
    }

    @GetMapping("/recipes")
    public String getRecipes(Model model) {
        List<Recipe> recipes = recipeService.getAllRecipes();
        model.addAttribute("recipes", recipes);
        return "recipe/list";
    }

    @GetMapping("/recipe/add")
    public String addRecipe(Model model) {
        Recipe recipe = new Recipe();
        recipe.setSteps(new ArrayList<>());
        recipe.setIngredients(new ArrayList<>());
        model.addAttribute("recipe", recipe);
        model.addAttribute("categories", categoryService.getAllCategories());
        return "recipe/form";
    }
    @GetMapping("/recipe/edit")
    public String editRecipe(@RequestParam(name = "id") long id, Model model) {
        model.addAttribute("categories", categoryService.getAllCategories());
        model.addAttribute("recipe", recipeService.getRecipe(id));
        return "recipe/form";
    }
    @GetMapping("/recipe/detail")
    public String detailRecipe(@RequestParam(name = "id") long id, Model model) {
        model.addAttribute("recipe", recipeService.getRecipe(id));
        return "recipe/detail";
    }
    @GetMapping("/recipe/delete")
    public String deleteRecipe(@RequestParam(name = "id") long id) {
        recipeService.removeRecipe(id);
        return "redirect:/recipes";
    }

    @PostMapping("/recipe/form")
    public String formRecipe(@Valid @ModelAttribute("recipe") Recipe recipe, BindingResult result) {
        if (result.hasErrors()) {
            return "recipe/form";
        }
        Category category = categoryService.getCategoryById(recipe.getCategoryId());
        recipe.setCategory(category);
        if(recipe.getId() != 0){
            recipeService.updateRecipe(recipe.getId(), recipe);
        }else{
            recipeService.addRecipe(recipe);
        }
        return "redirect:/recipes";
    }
}