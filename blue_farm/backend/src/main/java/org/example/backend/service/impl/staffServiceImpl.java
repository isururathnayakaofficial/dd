package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.staffDto;
import org.example.backend.entity.impl.staffEntity;
import org.example.backend.repository.staffRepo;
import org.example.backend.service.staffService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class staffServiceImpl implements staffService {

    private final staffRepo staffRepository;

    @Override
    public staffDto saveStaff(staffDto dto) {

        staffEntity entity = new staffEntity();
        entity.setName(dto.getName());
        entity.setDesignation(dto.getDesignation());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        staffRepository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    @Override
    public List<staffDto> getAllStaff() {

        return staffRepository.findAll().stream().map(s -> {

            staffDto dto = new staffDto();
            dto.setId(s.getId());
            dto.setName(s.getName());
            dto.setDesignation(s.getDesignation());
            dto.setEmail(s.getEmail());
            dto.setPhone(s.getPhone());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public staffDto updateStaff(Long id, staffDto dto) {

        staffEntity entity = staffRepository.findById(id).orElseThrow();

        entity.setName(dto.getName());
        entity.setDesignation(dto.getDesignation());
        entity.setEmail(dto.getEmail());
        entity.setPhone(dto.getPhone());

        staffRepository.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    @Override
    public void deleteStaff(Long id) {

        staffRepository.deleteById(id);

    }
}