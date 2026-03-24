package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.userDto;
import org.example.backend.entity.impl.userEntity;
import org.example.backend.repository.userRepo;
import org.example.backend.service.userService;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class userServiceImpl implements userService {

    private final userRepo userRepository;
    private final PasswordEncoder passwordEncoder;

    @Override
    public userDto saveUser(userDto dto) {

        userEntity entity = new userEntity();
        entity.setUsername(dto.getUsername());
        entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        entity.setRole(dto.getRole() != null ? dto.getRole() : "USER");

        userRepository.save(entity);

        dto.setId(entity.getId());
        dto.setPassword(null);

        return dto;
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
    public userDto updateUser(Long id, userDto dto) {

        userEntity entity = userRepository.findById(id).orElseThrow();

        entity.setUsername(dto.getUsername());

        if (dto.getPassword() != null && !dto.getPassword().isBlank()) {
            entity.setPassword(passwordEncoder.encode(dto.getPassword()));
        }

        if (dto.getRole() != null) {
            entity.setRole(dto.getRole());
        }

        userRepository.save(entity);

        dto.setId(entity.getId());
        dto.setPassword(null);

        return dto;
    }

    @Override
    public void deleteUser(Long id) {

        userRepository.deleteById(id);

    }
}