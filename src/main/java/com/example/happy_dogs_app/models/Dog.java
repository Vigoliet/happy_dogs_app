package com.example.happy_dogs_app.models;

import jakarta.persistence.*;
import lombok.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "dogs")

public class Dog {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;

    private String breed;

    private String imageUrl;

    @ManyToOne
    private Person owner;

 
}
