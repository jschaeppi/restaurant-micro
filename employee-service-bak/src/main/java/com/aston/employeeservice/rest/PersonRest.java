package com.aston.employeeservice.rest;

import com.aston.employeeservice.domain.Person;
import com.aston.employeeservice.services.PersonService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController()
@RequestMapping("/api/v1/person")
public class PersonRest {

    Logger log = LoggerFactory.getLogger(PersonRest.class);

    private PersonService personService;

    public PersonRest(PersonService personService) {
        this.personService = personService;
    }


    @GetMapping("/")
    public ResponseEntity<List<Person>> getPersons() {
        List<Person> personList = this.personService.getPeople();
        if (personList.size() == 0) {
            log.debug("No people were found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new ArrayList<Person>());
        }
        return ResponseEntity.ok().body(personList);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getPerson(@PathVariable Integer id) {
        Person person = this.personService.getPerson(id);
        if (person.equals(null)) {
            log.debug("No person was found");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Person());
        }
        return ResponseEntity.ok().body(person);
    }

/*    @GetMapping("/{empNum}")
    public ResponseEntity<Person> getPersonByName(@PathVariable String empNum) {
        Person savedPerson = this.personService.getPersonByNum(empNum);
        if (savedPerson.equals(null)) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Person());
        }
        return ResponseEntity.ok().body(savedPerson);
    }*/

    @PostMapping("/")
    public ResponseEntity<Person> createPerson(@RequestBody Person person) {
        Person savedPerson = this.personService.addPerson(person);
        if (savedPerson.equals(null)) {
            log.debug("Person wasn't saved properly");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Person());
        }
        return ResponseEntity.ok().body(person);
    }

    @PutMapping("/")
    public ResponseEntity<Person> updatePerson(@RequestBody Person person) {
        Person savedPerson = this.personService.addPerson(person);
        if (savedPerson.equals(null)) {
            log.debug("Person couldn't be updated");
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(new Person());
        }
        return ResponseEntity.ok().body(person);
    }
}
