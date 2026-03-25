package org.example.backend.service;

import org.example.backend.dto.StaffDTO;
import org.example.backend.dto.impl.staffDto;

import java.util.List;

public interface staffService {

    void saveStaff(StaffDTO dto);

    List<staffDto> getAllStaff();

    void updateStaff(Long id, StaffDTO dto);

    void deleteStaff(Long id);
}