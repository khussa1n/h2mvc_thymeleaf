package com.example.h2mvc_thymeleaf.repository;

import com.example.h2mvc_thymeleaf.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person, Integer> {
}
