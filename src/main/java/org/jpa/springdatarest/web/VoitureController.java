package org.jpa.springdatarest.web;

import org.jpa.springdatarest.Modele.Voiture;
import org.jpa.springdatarest.Modele.VoitureRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@CrossOrigin(origins = "*")
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


    @DeleteMapping("/delete/{id}")
    public ResponseEntity<Void> deleteVoiture(@PathVariable Long id) {
        if (!voitureRepo.existsById(id)) {
            return ResponseEntity.notFound().build();
        }
        voitureRepo.deleteById(id);
        return ResponseEntity.noContent().build();
    }


    @PutMapping("/{id}")
    public Voiture updateVoiture(@PathVariable Long id, @RequestBody Voiture updatedVoiture) {
        // Check if the Voiture exists
        return voitureRepo.findById(id).map(voiture -> {
            voiture.setMarque(updatedVoiture.getMarque()); // Update the necessary fields
            voiture.setModele(updatedVoiture.getModele());
            voiture.setAnnee(updatedVoiture.getAnnee());
            // Add other fields as needed
            return voitureRepo.save(voiture);
        }).orElseThrow(() -> new RuntimeException("Voiture not found with id " + id));
    }

    @GetMapping("/{id}")
    public ResponseEntity<Voiture> getVoitureById(@PathVariable Long id) {
        Optional<Voiture> voiture = voitureRepo.findById(id);
        return voiture.map(ResponseEntity::ok)
                .orElseGet(() -> ResponseEntity.notFound().build());
    }




}
