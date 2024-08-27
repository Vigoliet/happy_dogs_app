package com.example.happy_dogs_app.repositories;

import com.example.happy_dogs_app.models.Person;
import org.springframework.data.repository.CrudRepository;

public interface PersonController extends CrudRepository<Person, Long> {
}
