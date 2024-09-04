package com.example.happy_dogs_app.controllers;

import com.example.happy_dogs_app.models.Person;
import com.example.happy_dogs_app.services.PersonService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/persons")
@RequiredArgsConstructor
public class PersonController {
    private final PersonService service;


    @PostMapping
    public ResponseEntity<String> createPerson(@RequestBody Person person){
        var created = service.createPerson(person);

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

}
