package com.example.happy_dogs_app.models;

import jakarta.persistence.*;
import lombok.*;


@Entity
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@ToString
@Table(name = "persons")
public class Person {

    @Id
    @GeneratedValue(strategy = GenerationType.UUID)
    private String id;

    private String name;



}
