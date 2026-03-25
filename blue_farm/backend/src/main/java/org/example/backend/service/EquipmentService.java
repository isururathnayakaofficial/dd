package org.example.backend.service;

import org.example.backend.dto.EquipmentDTO;
import org.example.backend.dto.impl.EquipmentDto;

import java.util.List;

public interface EquipmentService {

    void saveEquipment(EquipmentDTO dto);

    List<EquipmentDto> getAllEquipment();

    void updateEquipment(Long id, EquipmentDTO dto);

    void deleteEquipment(Long id);
}