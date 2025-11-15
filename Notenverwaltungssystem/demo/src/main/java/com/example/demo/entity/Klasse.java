package com.example.demo.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "klasse")
public class Klasse {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name; 

    // Standard-Konstruktor
    public Klasse() {
    }

    // All-Args-Konstruktor
    public Klasse(Long id, String name) {
        this.id = id;
        this.name = name;
    }

    // Getter und Setter
    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "klasse{" +
                "id=" + id +
                ", name='" + name + '\'' +
                '}';
    }
}
