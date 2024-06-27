package org.tp_kitchen.service;

import org.springframework.stereotype.Service;
import org.tp_kitchen.model.Category;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class CategoryService {
    private final Map<Long, Category> categories;
    public CategoryService() {
        categories = new HashMap<>();

        Category category = Category.builder()
                .name("French cuisine")
                .description("French cuisine is the cooking traditions and practices from France.")
                .id((long) categories.size() + 1)
                .build();
        categories.put(category.getId(), category);
        Category category2 = Category.builder()
                .name("Chinese cuisine")
                .description("Chinese cuisine comprises cuisines originating from China, as well as from Chinese people from other parts of the world.")
                .id((long) categories.size() + 1)
                .build();
        categories.put(category2.getId(), category2);
    }

    public Category getCategoryById(long id) {
        return categories.get(id);
    }

    public List<Category> getAllCategories() {
        return new ArrayList<>(categories.values());
    }

    public void addCategory(Category category) {
        long id = categories.size() + 1;
        category.setId(id);
        categories.put(id, category);
    }
    public void updateCategory(long id, Category category) {
        if (categories.containsKey(id)) {
            categories.put(id, category);
        }
    }
    public void deleteCategory(long id) {
        categories.remove(id);
    }
}
