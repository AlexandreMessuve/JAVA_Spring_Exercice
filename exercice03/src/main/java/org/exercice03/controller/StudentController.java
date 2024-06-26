package org.exercice03.controller;

import jakarta.validation.Valid;
import org.exercice03.model.Student;
import org.exercice03.service.StudentService;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.UUID;

@Controller
public class StudentController {
    private final StudentService studentService;

    public StudentController(StudentService studentService) {
        this.studentService = studentService;
    }

    @GetMapping("/")
    public String index() {
        return "index";
    }

    @GetMapping("/students")
    public String students(Model model) {
        model.addAttribute("students", studentService.getAllStudents());
        return "student/list";
    }

    @GetMapping("/students/detail/{id}")
    public String detail(@PathVariable("id") UUID id, Model model) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return "redirect:/";
        }
        model.addAttribute("student", student);
        return "student/detail";
    }

    @GetMapping("/students/add")
    public String add(Model model) {
        model.addAttribute("student", new Student());
        return "student/form";
    }

    @GetMapping("/students/edit/{id}")
    public String edit(@PathVariable(name = "id") UUID id, Model model) {
        Student student = studentService.getStudent(id);
        if (student == null) {
            return "redirect:/students";
        }
        model.addAttribute("student", student);
        return "student/form";
    }

    @GetMapping("/students/search")
    public String search(@RequestParam(name="lastname") String lastname ,Model model) {
        List<Student> students = studentService.getStudentByName(lastname);
        model.addAttribute("students", students);
        return "student/list";
    }
    @PostMapping("/students/form")
    public String add(@Valid @ModelAttribute("student") Student student, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "student/form";
        }else{
            if (student.getId() != null) {
                studentService.updateStudent(student.getId(), student);
            }else {
                studentService.addStudent(student);
            }
            return "redirect:/students";
        }
    }

    @GetMapping("/students/delete/{id}")
    public String delete(@PathVariable("id") UUID id) {
        if (studentService.removeStudent(id)){
            return "redirect:/students";
        }else {
            return "redirect:/";
        }
    }
}
