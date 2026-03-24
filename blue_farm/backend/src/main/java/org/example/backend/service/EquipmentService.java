package org.example.backend.service;

import org.example.backend.dto.impl.EquipmentDto;

import java.util.List;

public interface EquipmentService {

    EquipmentDto saveEquipment(EquipmentDto dto);

    List<EquipmentDto> getAllEquipment();

    EquipmentDto updateEquipment(Long id, EquipmentDto dto);

    void deleteEquipment(Long id);
}