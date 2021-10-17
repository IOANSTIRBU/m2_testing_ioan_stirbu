package com.example.m2_testing_ioan_stirbu.repositories;

import com.example.m2_testing_ioan_stirbu.entities.Nave;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface NavesRepository extends JpaRepository<Nave,Long> {




}
