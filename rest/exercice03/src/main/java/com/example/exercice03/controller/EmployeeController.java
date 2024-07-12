package com.example.exercice03.controller;

import com.example.exercice03.dto.employee.EmployeeDtoGet;
import com.example.exercice03.dto.employee.EmployeeDtoPost;
import com.example.exercice03.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class EmployeeController {
    @Autowired
    private EmployeeService employeeService;

    @GetMapping("/employee")
    public ResponseEntity<List<EmployeeDtoGet>> getAllEmployees() {
        return ResponseEntity.ok(employeeService.findAll());
    }

    @GetMapping("/employee/{id}")
    public ResponseEntity<EmployeeDtoGet> getEmployeeById(@PathVariable int id) {
        return ResponseEntity.ok(employeeService.findById(id));
    }

    @PostMapping("/employee/add")
    public ResponseEntity<EmployeeDtoGet> addEmployee(@RequestBody EmployeeDtoPost employeeDtoPost) {
        return ResponseEntity.status(HttpStatus.CREATED).body(employeeService.create(employeeDtoPost));
    }

    @PutMapping("/employee/{id}")
    public ResponseEntity<EmployeeDtoGet> updateEmployee(@PathVariable int id, @RequestBody EmployeeDtoPost employeeDtoPost) {
        return ResponseEntity.ok(employeeService.update(id, employeeDtoPost));
    }

    @DeleteMapping("/employee/{id}")
    public ResponseEntity<String> deleteEmployee(@PathVariable int id) {
        employeeService.delete(id);
        return ResponseEntity.ok("Employee with id " + id + " deleted successfully");
    }


}
