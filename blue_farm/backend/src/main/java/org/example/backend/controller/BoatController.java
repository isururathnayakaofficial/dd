package org.example.backend.controller;

import org.example.backend.dto.impl.BoatDto;
import org.example.backend.service.BoatService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/boat")
@CrossOrigin
public class BoatController {

    private final BoatService boatService;

    public BoatController(BoatService boatService){
        this.boatService = boatService;
    }

    @PostMapping("/save")
    public BoatDto saveBoat(@RequestBody BoatDto dto){
        return boatService.saveBoat(dto);
    }

    @GetMapping
    public List<BoatDto> getAllBoats(){
        return boatService.getAllBoats();
    }

    @PutMapping("/{id}")
    public BoatDto updateBoat(@PathVariable Long id,
                              @RequestBody BoatDto dto){
        return boatService.updateBoat(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteBoat(@PathVariable Long id){
        boatService.deleteBoat(id);
    }
}