package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.PondDTO;
import org.example.backend.dto.impl.PondDto;
import org.example.backend.service.PondService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/pond")
@RequiredArgsConstructor
@CrossOrigin
public class PondController {

    private final PondService pondService;

    @PostMapping("/save")
    public void savePond(@RequestBody PondDTO dto){
        pondService.savePond(dto);
    }

    @GetMapping
    public List<PondDto> getAllPonds(){
        return pondService.getAllPonds();
    }

    @PutMapping("/update/{id}")
    public void updatePond(@PathVariable Long id,
                              @RequestBody PondDTO dto){
        pondService.updatePond(id, dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deletePond(@PathVariable Long id){
        pondService.deletePond(id);
    }
}