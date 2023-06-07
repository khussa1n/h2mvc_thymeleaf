package com.example.h2mvc_thymeleaf.controller;

import com.example.h2mvc_thymeleaf.model.Person;
import com.example.h2mvc_thymeleaf.service.PersonService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

@Controller
public class PersonController {

    @Autowired
    private PersonService personService;

    @RequestMapping(value = "/person", method = RequestMethod.GET)
    public String getAll(Model model) {
        List<Person> persons = personService.getAll();
        model.addAttribute("persons", persons);
        return "index.html";
    }

    @RequestMapping(value = "/person/create", method = RequestMethod.GET)
    public String createPerson(Model model) {
        Person person = new Person();
        model.addAttribute("person", person);
        return "createPerson.html";
    }

    @RequestMapping(value = "/person/save", method = RequestMethod.POST)
    public String savePerson(@ModelAttribute("person") Person person) {
        personService.save(person);
        return "redirect:/person";
    }

    @RequestMapping(value = "/person/update{id}", method = RequestMethod.GET)
    public String updatePerson(@PathVariable(value = "id") int id, Model model) {
        Person person = personService.get(id);
        model.addAttribute("person", person);
        return "updatePerson.html";
    }

    @RequestMapping(value = "/person/delete{id}", method = RequestMethod.GET)
    public String deletePerson(@PathVariable(value = "id") int id) {
        personService.delete(id);
        return "redirect:/person";
    }
}
