package com.example.h2mvc_thymeleaf.service;

import com.example.h2mvc_thymeleaf.model.Person;
import com.example.h2mvc_thymeleaf.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PersonService {

    @Autowired
    private PersonRepository personRepository;

    public Person save(Person person) {
        return personRepository.save(person);
    }

    public List<Person> getAll() {
        return personRepository.findAll();
    }

    public Person get(int id) {
        return personRepository.getById(id);
    }

    public void delete(int id) {
        personRepository.deleteById(id);
    }
}
