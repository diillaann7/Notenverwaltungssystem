package com.example.demo.entity_repository;

import java.util.List;

import com.example.demo.entity.Klasse;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface KlasseRepository extends JpaRepository<Klasse, Long> {
    List<Klasse> findByName(String name);
}
