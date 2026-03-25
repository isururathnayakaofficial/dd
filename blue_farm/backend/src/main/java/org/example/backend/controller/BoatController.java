package org.example.backend.controller;

import org.example.backend.dto.BoatDTO;
import org.example.backend.entity.Boat;
import org.example.backend.service.BoatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/boat")
@CrossOrigin
public class BoatController {

    private final BoatService boatService;

    public BoatController(BoatService boatService){
        this.boatService = boatService;
    }

    @PostMapping("/save")
    public void saveBoat(@RequestBody BoatDTO dto){
       boatService.saveBoat(dto);
    }

    @GetMapping
    public List<BoatDTO> getAllBoats(){
        return boatService.getAllBoats();
    }

    @PutMapping("/update/{id}")
    public void updateBoat(@PathVariable Long id,
                              @RequestBody BoatDTO dto){
        boatService.updateBoat(id, dto);

    }

    @DeleteMapping("/delete/{id}")
    public void deleteBoat(@PathVariable Long id){
        boatService.deleteBoat(id);
    }
}