package com.example.demo.dto;

public class StudentDTO {
    private String name;
    private Integer age;
    private String email;

    // Kein-Argument-Konstruktor
    public StudentDTO() {
    }

    // Konstruktor mit allen Feldern
    public StudentDTO(String name, Integer age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }

    // Getter und Setter für 'name'
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    // Getter und Setter für 'age'
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    // Getter und Setter für 'email'
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
