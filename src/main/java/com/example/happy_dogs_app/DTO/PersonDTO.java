package com.example.happy_dogs_app.DTO;

import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.models.Person;
import lombok.Data;

import java.util.List;

@Data
public class PersonDTO {


    private String id;

    private String name;


    public Person toPerson(){
        return new Person(id, name, null);
    }

}
