package org.example.backend.service;

import org.example.backend.dto.PondDTO;
import org.example.backend.dto.impl.PondDto;

import java.util.List;

public interface PondService {

    void savePond(PondDTO dto);

    List<PondDto> getAllPonds();

    void updatePond(Long id, PondDTO dto);

    void deletePond(Long id);
}