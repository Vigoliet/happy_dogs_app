package com.example.happy_dogs_app.services;

import com.example.happy_dogs_app.models.Person;
import com.example.happy_dogs_app.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public boolean createPerson(Person person) {
        try {
            repository.save(person);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<Person> getAllPersons() {
        return repository.findAll();
    }

}
