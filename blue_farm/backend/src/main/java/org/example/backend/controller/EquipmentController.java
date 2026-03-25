package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.EquipmentDTO;
import org.example.backend.dto.impl.EquipmentDto;
import org.example.backend.service.EquipmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/equipment")
@RequiredArgsConstructor
@CrossOrigin
public class EquipmentController {


    private final EquipmentService equipmentService;

    @PostMapping("/save")
    public void saveEquipment(@RequestBody EquipmentDTO dto){
        equipmentService.saveEquipment(dto);
    }

    @GetMapping
    public List<EquipmentDto> getAllEquipment(){
        return equipmentService.getAllEquipment();
    }

    @PutMapping("/{id}")
    public EquipmentDto updateEquipment(@PathVariable Long id,
                                        @RequestBody EquipmentDto dto){
        return equipmentService.updateEquipment(id, dto);
    }

    @DeleteMapping("/{id}")
    public void deleteEquipment(@PathVariable Long id){
        equipmentService.deleteEquipment(id);
    }
}