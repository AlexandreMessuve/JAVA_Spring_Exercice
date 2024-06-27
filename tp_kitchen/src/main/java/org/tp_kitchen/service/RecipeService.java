package org.tp_kitchen.service;

import org.springframework.stereotype.Service;
import org.tp_kitchen.model.Category;
import org.tp_kitchen.model.Recipe;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class RecipeService {
    private final Map<Long, Recipe> recipes;
    public RecipeService(){
        CategoryService categoryService = new CategoryService();
        recipes = new HashMap<>();

        List<String> ingredients1 = new ArrayList<>();
        List<String> steps1 = new ArrayList<>();
        ingredients1.add("5-7 Potatoes");
        ingredients1.add("Salt");
        steps1.add("1- Cut the potatoes");
        steps1.add("2- Heat the oil to 220°C in a frying pan or deep fryer");
        steps1.add("3- Add the potatoes in the oil and waiting 5-7 minutes");
        steps1.add("4- Add a pinch of salt");
        steps1.add("5- Enjoy this ! ");
        Recipe recipe1 = Recipe.builder()
                .name("French Fries")
                .ingredients(ingredients1)
                .steps(steps1)
                .category(categoryService.getCategoryById(1))
                .id(recipes.size() + 1)
                .build();
    }

    public Recipe getRecipe(long id){
        return recipes.get(id);
    }
    public List<Recipe> getRecipesByCategory(Category category){
        return recipes.values().stream().filter(r -> r.getCategory().equals(category)).toList();
    }
    public List<Recipe> getAllRecipes(){
        return new ArrayList<>(recipes.values());
    }

    public void addRecipe(Recipe recipe){
        long id = recipes.size() + 1;
        recipe.setId(id);
        recipes.put(id, recipe);
    }

    public void updateRecipe(long id, Recipe recipe){
        if(recipes.containsKey(id)){
            recipes.put(id, recipe);
        }
    }
    public void removeRecipe(long id){
        recipes.remove(id);
    }
}
