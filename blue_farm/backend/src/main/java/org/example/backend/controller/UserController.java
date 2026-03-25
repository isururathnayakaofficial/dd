package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.UserDTO;
import org.example.backend.dto.impl.userDto;
import org.example.backend.service.userService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/user")
@RequiredArgsConstructor
@CrossOrigin
public class UserController {

    private final userService userService;

    @PostMapping("/save")
    public void saveUser(@RequestBody UserDTO dto){
         userService.saveUser(dto);
    }

    @GetMapping
    public List<userDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/update/{id}")
    public void updateUser(@PathVariable Long id,@RequestBody UserDTO dto){
         userService.updateUser(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}