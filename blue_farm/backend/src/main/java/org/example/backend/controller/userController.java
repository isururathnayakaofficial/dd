package org.example.backend.controller;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.userDto;
import org.example.backend.service.userService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/user")
@RequiredArgsConstructor
@CrossOrigin
public class userController {

    private final userService userService;

    @PostMapping
    public userDto saveUser(@RequestBody userDto dto){
        return userService.saveUser(dto);
    }

    @GetMapping
    public List<userDto> getAllUsers(){
        return userService.getAllUsers();
    }

    @PutMapping("/{id}")
    public userDto updateUser(@PathVariable Long id,@RequestBody userDto dto){
        return userService.updateUser(id,dto);
    }

    @DeleteMapping("/{id}")
    public void deleteUser(@PathVariable Long id){
        userService.deleteUser(id);
    }
}