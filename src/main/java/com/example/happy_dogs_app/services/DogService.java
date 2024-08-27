package com.example.happy_dogs_app.services;

import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.repositories.DogRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Optional;

@RequiredArgsConstructor
@Service
public class DogService {

    private final DogRepository repository;

    public boolean createDog(Dog dog){
        try {
            repository.save(dog);
            return true;
        } catch (Exception e) {
            return false;
        }
    }

    public Iterable<Dog> getAllDogs(){
        return repository.findAll();
    }

    public Optional<Dog> getDogById(String id){
        return repository.findById(id);
    }

    public boolean updateDog(String id, Dog updateDog){
        Optional<Dog> existingDog = repository.findById(id);

        if (existingDog.isPresent()) {
            Dog dog = existingDog.get();

            dog.setName(updateDog.getName());
            dog.setBreed(updateDog.getBreed());
            dog.setImageUrl(updateDog.getImageUrl());

            return true;

        } else{
            return false;
        }
    }


}
