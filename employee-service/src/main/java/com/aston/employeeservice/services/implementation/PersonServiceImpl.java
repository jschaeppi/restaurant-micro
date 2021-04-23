package com.aston.employeeservice.services.implementation;

import com.aston.employeeservice.domain.Person;
import com.aston.employeeservice.repositories.PersonRespository;
import com.aston.employeeservice.services.PersonService;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class PersonServiceImpl implements PersonService {

    private PersonRespository personRespository;

    public PersonServiceImpl(PersonRespository personRespository) {
        this.personRespository = personRespository;
    }

    @Override
    public List<Person> getPeople() {
        List<Person> personList = new ArrayList<>();
        this.personRespository.findAll().iterator().forEachRemaining(personList::add);
        return personList;
    }

    @Override
    public Person getPerson(Integer id) {
        return this.personRespository.findById(id).orElse(null);
    }

/*    @Override
    public Person getPersonByName(String name) {
        return this.personRespository.getPersonByName(name);
    }*/

    @Override
    public Person addPerson(Person person) {
        return this.personRespository.save(person);
    }

    @Override
    public Person updatePerson(Person person) {
        return this.personRespository.save(person);
    }
}
