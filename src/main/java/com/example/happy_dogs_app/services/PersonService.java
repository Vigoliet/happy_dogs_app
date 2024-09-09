package com.example.happy_dogs_app.services;

import com.example.happy_dogs_app.DTO.PersonDTO;
import com.example.happy_dogs_app.models.Person;
import com.example.happy_dogs_app.repositories.PersonRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
@RequiredArgsConstructor
public class PersonService {

    private final PersonRepository repository;

    public boolean createPerson(PersonDTO dto) {
        try {
            repository.save(dto.toPerson());
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<Person> getAllPersons() {
        return repository.findAll();
    }

    public Optional<Person> getPersonById(String id) {
        return repository.findById(id);
    }

    public boolean updatePerson(String id, Person updatedPerson){
        var existingPerson = repository.findById(id);

        if (existingPerson.isPresent()) {
            Person person = existingPerson.get();

            person.setName(updatedPerson.getName());

            repository.save(person);

            return true;
        }
        else{
            return false;
        }
    }

    public boolean deletePerson(String id) {
        try {
            repository.deleteById(id);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

}
