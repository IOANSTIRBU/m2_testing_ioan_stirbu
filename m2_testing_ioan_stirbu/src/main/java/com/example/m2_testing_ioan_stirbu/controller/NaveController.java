package com.example.m2_testing_ioan_stirbu.controller;

import com.example.m2_testing_ioan_stirbu.entities.Nave;
import org.springframework.web.bind.annotation.*;
import com.example.m2_testing_ioan_stirbu.repositories.NavesRepository;

import java.util.List;

@RestController
public class NaveController {

    //Creando Repositorio
    NavesRepository navesRepository;

    public NaveController(NavesRepository navesRepository){
        this.navesRepository = navesRepository;
    }


    @GetMapping("/data/nave")
    public void demoData(){
        Nave n1 = new Nave(null,"Galactica",3.200D,33.200D);
        navesRepository.save(n1);
        Nave n2 = new Nave(null,"InterStellar",5.000,44.000D);
        navesRepository.save(n2);


    }

    //Get
    @GetMapping("/naves")
    public List<Nave> findAll(){
        return navesRepository.findAll();
    }

    //Post
    @PostMapping("/naves")
    public void create(@RequestBody Nave nave){
        System.out.println(nave);
        if(nave.getId() == null)
            navesRepository.save(nave);
    }

    //Put
    @PutMapping("/naves")
    public void update(@RequestBody Nave nave){
        if(nave.getId() != null && navesRepository.existsById(nave.getId()))
            navesRepository.save(nave);
    }

    //Delete
    @DeleteMapping("/naves/{id}")
    public void deleteById(@PathVariable Long id){
        if(navesRepository.existsById(id))
            navesRepository.deleteById(id);
    }








}
