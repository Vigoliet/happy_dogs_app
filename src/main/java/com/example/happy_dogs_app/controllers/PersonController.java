package com.example.happy_dogs_app.controllers;

import com.example.happy_dogs_app.DTO.PersonDTO;
import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.models.Person;
import com.example.happy_dogs_app.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;


    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody PersonDTO requestBody){
        var created = service.createPerson(requestBody);

        if(created){
            return new ResponseEntity<>("Person created successfully", HttpStatus.CREATED);
        }
        else{
            return new ResponseEntity<>("Failed to create person", HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @GetMapping
    public ResponseEntity<Iterable<Person>> getAllPersons(){
        var persons = service.getAllPersons();
        return new ResponseEntity<>(persons, HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Person> getDogById(@PathVariable String id){
        Optional<Person> person = service.getPersonById(id);

        if (person.isPresent()) {
            return new ResponseEntity<>(person.get(), HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<String> updatePerson(@PathVariable String id, @RequestBody Person updatedPerson){
        var isUpdated = service.updatePerson(id, updatedPerson);
        if (isUpdated){
            return new ResponseEntity<>("Person updated successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to update person", HttpStatus.NOT_FOUND);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<String> deletePerson(@PathVariable String id){
        var isDeleted = service.deletePerson(id);
        if (isDeleted) {
            return new ResponseEntity<>("Person deleted successfully", HttpStatus.OK);
        } else {
            return new ResponseEntity<>("Failed to delete person", HttpStatus.NOT_FOUND);
        }

    }

}
