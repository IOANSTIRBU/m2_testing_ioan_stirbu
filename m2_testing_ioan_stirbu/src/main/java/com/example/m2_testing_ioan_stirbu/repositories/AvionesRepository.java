package com.example.m2_testing_ioan_stirbu.repositories;


import com.example.m2_testing_ioan_stirbu.entities.Avion;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface AvionesRepository extends JpaRepository<Avion,Long> {
}
