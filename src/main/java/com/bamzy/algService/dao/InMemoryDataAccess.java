package com.bamzy.algService.dao;

import com.bamzy.algService.model.Person;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;


@Repository("fakeDao")
public class InMemoryDataAccess implements PersonDao {
    private static List<Person> DB = new ArrayList<>();
    @Override
    public int insertPerson(UUID id, Person person) {
        DB.add(new Person(id,person.getName()));
        return 1;
    }

    @Override
    public List<Person> selectAllPersons() {
        return DB;
    }

    @Override
    public boolean deletePersonById(UUID id) {
        Optional<Person> person = selectPersonById(id);
        if (person.isEmpty())
            return false;
        DB.remove(person.get());
        return true;
    }

    @Override
    public boolean updatePersonById(UUID id, Person person) {
        return selectPersonById(id).map(p -> {
            int selectedId = DB.indexOf(p);
            if (selectedId >= 0 ){
                DB.set(selectedId,new Person(id,person.getName()));
                return true;
            } else
                return false;
        }).orElse( false);

    }

    @Override
    public Optional<Person> selectPersonById(UUID id) {
       return DB.stream().filter( (person) -> {return person.getId().equals(id);}).findFirst();
    }


}
