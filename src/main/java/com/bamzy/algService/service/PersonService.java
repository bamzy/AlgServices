package com.bamzy.algService.service;

import com.bamzy.algService.dao.PersonDao;
import com.bamzy.algService.model.Person;

public class PersonService {
    private final PersonDao personDao;

    public PersonService(PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }
}
