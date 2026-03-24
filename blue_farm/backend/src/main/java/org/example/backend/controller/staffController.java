package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.staffDto;
import org.example.backend.service.staffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/staff")
@RequiredArgsConstructor
@CrossOrigin
public class staffController {

    private final staffService staffService;

    @PostMapping
    public staffDto saveStaff(@RequestBody staffDto dto){
        return staffService.saveStaff(dto);
    }

    @GetMapping
    public List<staffDto> getAllStaff(){
        return staffService.getAllStaff();
    }

    @PutMapping("/{id}")
    public staffDto updateStaff(@PathVariable Long id,@RequestBody staffDto dto){
        return staffService.updateStaff(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteStaff(@PathVariable Long id){
        staffService.deleteStaff(id);
    }
}