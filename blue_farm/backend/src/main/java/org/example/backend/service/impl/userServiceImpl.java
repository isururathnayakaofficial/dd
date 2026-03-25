package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.UserDTO;
import org.example.backend.dto.impl.userDto;
import org.example.backend.entity.User;
import org.example.backend.entity.impl.userEntity;
import org.example.backend.repository.UserRepo;
import org.example.backend.service.userService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final UserRepo userRepository;
    private final PasswordEncoder passwordEncoder;
    @Override
    public void  saveUser(UserDTO dto) {

        User entity = new User();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setRole(dto.getRole() != null ? dto.getRole() : "USER");

        userRepository.save(entity);
    }

    @Override
    public List<userDto> getAllUsers() {

        return userRepository.findAll().stream().map(u -> {

            userDto dto = new userDto();
            dto.setId(u.getId());
            dto.setUsername(u.getUsername());
            dto.setRole(u.getRole());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public void updateUser(Long id, UserDTO dto) {

        User entity = userRepository.findById(id).orElseThrow();

        entity.setUsername(dto.getUsername());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getRole() != null) {
            entity.setRole(dto.getRole());
        }

        userRepository.save(entity);

    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}