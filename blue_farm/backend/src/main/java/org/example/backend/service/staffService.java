package org.example.backend.service;

import org.example.backend.dto.impl.staffDto;

import java.util.List;

public interface staffService {

    staffDto saveStaff(staffDto dto);

    List<staffDto> getAllStaff();

    staffDto updateStaff(Long id, staffDto dto);

    void deleteStaff(Long id);
}