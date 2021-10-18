package com.example.m2_testing_ioan_stirbu.controller;

import com.example.m2_testing_ioan_stirbu.entities.Avion;
import com.example.m2_testing_ioan_stirbu.entities.Nave;
import com.example.m2_testing_ioan_stirbu.repositories.AvionesRepository;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class AvionController {




    //Creando Repositorio
    private AvionesRepository avionesRepository;


    public AvionController(AvionesRepository avionesRepository){
        this.avionesRepository = avionesRepository;
    }


    @GetMapping("/data/avion")
    public void demoData(){
        Avion av1 = new Avion(null, "Airbus 319", 23.3, 156, 7.200);
        Avion av2 = new Avion(null, "Airbus 330", 132.4, 293, 7.400);
        avionesRepository.save(av1);
        avionesRepository.save(av2);


    }

    //Get
    @GetMapping("/aviones")
    public List<Avion> findAll(){
        return avionesRepository.findAll();
    }

    //Post
    @PostMapping("/aviones")
    public void create(@RequestBody Avion avion){
        System.out.println(avion);
        if(avion.getId() == null)
            avionesRepository.save(avion);
    }

    //Put
    @PutMapping("/aviones")
    public void update(@RequestBody Avion avion){
        if(avion.getId() == null && avionesRepository.existsById(avion.getId()))
            avionesRepository.save(avion);
    }

    //Delete
    @DeleteMapping("/aviones/{id}")
    public void deleteById(@PathVariable Long id){
        if(avionesRepository.existsById(id))
            avionesRepository.deleteById(id);
    }

}
