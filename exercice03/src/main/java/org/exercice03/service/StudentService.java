package org.exercice03.service;

import org.exercice03.model.Student;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class StudentService {
    private final Map<UUID, Student> students;

    public StudentService() {
        students = new HashMap<>();
    }

    public boolean addStudent(Student student) {
        if (students.containsKey(student.getId())) {
            return false;
        }
        students.put(student.getId(), student);
        return true;
    }
    public Student getStudent(UUID id) {
        return students.get(id);
    }
    public List<Student> getAllStudents() {
        return students.values().stream().toList();
    }
    public boolean removeStudent(UUID id) {
        if (!students.containsKey(id)) {
            return false;
        }
        students.remove(id);
        return true;
    }

    public List<Student> getStudentByName(String lastName) {
        return students.values().stream().filter(student -> student.getLastname().toLowerCase().contains(lastName.toLowerCase())).toList();
    }
}
