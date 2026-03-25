package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.StaffDTO;
import org.example.backend.dto.impl.staffDto;
import org.example.backend.service.staffService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/staff")
@RequiredArgsConstructor
@CrossOrigin
public class staffController {

    private final staffService staffService;

    @PostMapping("/save")
    public void saveStaff(@RequestBody StaffDTO dto){
        staffService.saveStaff(dto);
    }

    @GetMapping
    public List<staffDto> getAllStaff(){
        return staffService.getAllStaff();
    }

    @PutMapping("/update/{id}")
    public void updateStaff(@PathVariable Long id,@RequestBody StaffDTO dto){
       staffService.updateStaff(id,dto);
    }

    @DeleteMapping("/delete/{id}")
    public void deleteStaff(@PathVariable Long id){
        staffService.deleteStaff(id);
    }
}