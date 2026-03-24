package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.PondDto;
import org.example.backend.service.PondService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/pond")
@RequiredArgsConstructor
@CrossOrigin
public class PondController {

    private final PondService pondService;

    @PostMapping
    public PondDto savePond(@RequestBody PondDto dto){
        return pondService.savePond(dto);
    }

    @GetMapping
    public List<PondDto> getAllPonds(){
        return pondService.getAllPonds();
    }

    @PutMapping("/{id}")
    public PondDto updatePond(@PathVariable Long id,
                              @RequestBody PondDto dto){
        return pondService.updatePond(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deletePond(@PathVariable Long id){
        pondService.deletePond(id);
    }
}