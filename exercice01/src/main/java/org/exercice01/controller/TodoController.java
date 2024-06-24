package org.exercice01.controller;

import org.exercice01.model.Todo;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.List;

@Controller
public class TodoController {

    @RequestMapping("/todos")
    @ResponseBody
    public List<Todo> getAllTodos(Model model) {
        List<Todo> todos = new ArrayList<>();
        todos.add(new Todo("Cleaning", "Clean keyboard", true));
        todos.add(new Todo("Cooking", "Chicken cook", false));
        todos.add(new Todo("Verify budget", "Descritpion .....", true));
        todos.add(new Todo("Plan the vacancy", "Descritpion .....", false));
        todos.add(new Todo("Cleaning", "Descritpion .....", true));
        model.addAttribute("todos", todos);
        return todos;
    }

    @RequestMapping("/todo")
    public String getOneTodos(Model model) {
        Todo todo = new Todo("Cleaning", "Clean keyboard", false);
        model.addAttribute("todo" , todo);
        return "todo/detail";
    }

    @RequestMapping("/")
    public String index(Model model) {
        return "home";
    }
}
