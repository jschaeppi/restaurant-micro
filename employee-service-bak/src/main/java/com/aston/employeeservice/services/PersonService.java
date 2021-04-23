package com.aston.employeeservice.services;

import com.aston.employeeservice.domain.Person;

import java.util.List;

public interface PersonService {

    public List<Person> getPeople();

    public Person getPerson(Integer id);

//    public Person getPersonByName(String name);

    public Person addPerson(Person person);

    public Person updatePerson(Person person);
}
