package com.example.exercice03.repository;

import com.example.exercice03.entity.Vacancy;
import org.springframework.data.jpa.repository.JpaRepository;

public interface VacancyRepository extends JpaRepository<Vacancy, Long> {
}
