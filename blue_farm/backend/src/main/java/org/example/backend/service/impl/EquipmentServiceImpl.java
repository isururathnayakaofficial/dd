package org.example.backend.service.impl;


import lombok.RequiredArgsConstructor;
import org.example.backend.dto.EquipmentDTO;
import org.example.backend.dto.impl.EquipmentDto;
import org.example.backend.entity.Equipment;
import org.example.backend.entity.impl.EquipmentEntity;
import org.example.backend.repository.EquipmentRepo;
import org.example.backend.service.EquipmentService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class EquipmentServiceImpl implements EquipmentService {

    private final EquipmentRepo equipmentRepo;



    @Override
    public void saveEquipment(EquipmentDTO dto) {

        Equipment entity = new Equipment();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setQuantity(dto.getQuantity());

        equipmentRepo.save(entity);

    }

    @Override
    public List<EquipmentDto> getAllEquipment() {

        return equipmentRepo.findAll().stream().map(e -> {

            EquipmentDto dto = new EquipmentDto();
            dto.setId(e.getId());
            dto.setName(e.getName());
            dto.setType(e.getType());
            dto.setQuantity(e.getQuantity());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public void updateEquipment(Long id, EquipmentDTO dto) {

        Equipment entity = equipmentRepo.findById(id).orElseThrow();

        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setQuantity(dto.getQuantity());

        equipmentRepo.save(entity);


    }

    @Override
    public void deleteEquipment(Long id) {

        equipmentRepo.deleteById(id);

    }
}