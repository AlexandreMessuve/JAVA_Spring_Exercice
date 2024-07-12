package com.example.exercice03.repository;

import com.example.exercice03.entity.Absence;
import org.springframework.data.jpa.repository.JpaRepository;

public interface AbsenceRepository extends JpaRepository<Absence, Integer> {
}
