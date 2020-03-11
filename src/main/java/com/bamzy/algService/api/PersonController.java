package com.bamzy.algService.api;

import com.bamzy.algService.model.Person;
import com.bamzy.algService.service.PersonService;

public class PersonController {
    private final PersonService personService;

    public PersonController(PersonService personService) {
        this.personService = personService;
    }
    public void addPerson(Person person){
        personService.addPerson(person);
    }
}
