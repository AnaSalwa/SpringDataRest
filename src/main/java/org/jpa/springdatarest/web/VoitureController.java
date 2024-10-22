package org.jpa.springdatarest.web;

import org.jpa.springdatarest.Modele.Voiture;
import org.jpa.springdatarest.Modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:3000")
@RequestMapping("/voitures")

public class VoitureController {

    @Autowired
    private VoitureRepo voitureRepo;
    @GetMapping("/all")
    public List<Voiture> getAll() {
        return (List<Voiture>) voitureRepo.findAll();
    }


    @PostMapping("/add")
    public ResponseEntity<Voiture> addVoiture(@RequestBody Voiture voiture) {
        System.out.println("Voiture reçue : " + voiture);
        return ResponseEntity.ok(voitureRepo.save(voiture));
    }


}
