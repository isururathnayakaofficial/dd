package org.example.backend.service;

import org.example.backend.dto.FishDTO;
import org.example.backend.dto.impl.FishDto;

import java.util.List;

public interface FishService {

    void saveFish(FishDTO dto);

    void updateFish(FishDto dto);

    List<FishDto> getAllFish();

    FishDto getFish(Long id);

    void deleteFish(Long id);
}