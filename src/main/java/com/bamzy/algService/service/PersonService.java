package com.bamzy.algService.service;

import com.bamzy.algService.dao.PersonDao;
import com.bamzy.algService.model.Person;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.UUID;

@Service
public class PersonService {
    private final PersonDao personDao;

    @Autowired
    public PersonService(@Qualifier("fakeDao") PersonDao personDao) {
        this.personDao = personDao;
    }
    public int addPerson(Person person){
        return personDao.insertPerson(person);
    }

    public List<Person> getAll(){
        return personDao.selectAllPersons();
    }

    public Optional<Person> getPersonById(UUID id){
        return personDao.selectPersonById(id);
    }

    public boolean deletePersonById(UUID id){
        return personDao.deletePersonById(id);
    }

    public boolean updatePersonById(UUID id, Person newPerson){
        return personDao.updatePersonById(id,newPerson);
    }
}
