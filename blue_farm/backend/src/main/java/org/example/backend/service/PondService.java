package org.example.backend.service;

import org.example.backend.dto.impl.PondDto;

import java.util.List;

public interface PondService {

    PondDto savePond(PondDto dto);

    List<PondDto> getAllPonds();

    PondDto updatePond(Long id, PondDto dto);

    void deletePond(Long id);
}