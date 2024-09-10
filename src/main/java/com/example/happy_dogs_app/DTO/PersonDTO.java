package com.example.happy_dogs_app.DTO;

import com.example.happy_dogs_app.models.Dog;
import com.example.happy_dogs_app.models.Person;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@NoArgsConstructor
public class PersonDTO {


    private String id;

    private String name;


    public PersonDTO(Person person){
        setId(person.getId());
        setName(person.getName());
    }


    public Person toPerson(){
        return new Person(id, name, null);
    }

}
