package org.example.backend.service;

import org.example.backend.dto.FishDTO;
import org.example.backend.dto.impl.FishDto;
import org.example.backend.entity.Fish;

import java.util.List;

public interface FishService {

    void saveFish(FishDTO dto);

    void updateFish(FishDTO dto,Long id);

    List<FishDto> getAllFish();

    Fish getFish(Long id);

    void deleteFish(Long id);
}