package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.EquipmentDto;
import org.example.backend.service.EquipmentService;

import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/equipment")
@RequiredArgsConstructor
@CrossOrigin
public class EquipmentController {


    private final EquipmentService equipmentService;

    @PostMapping
    public EquipmentDto saveEquipment(@RequestBody EquipmentDto dto){
        return equipmentService.saveEquipment(dto);
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