package org.example.backend.service;

import org.example.backend.dto.BoatDTO;
import org.example.backend.entity.Boat;

import java.util.List;

public interface BoatService {

    void saveBoat(BoatDTO boatDTO);

    List<BoatDTO> getAllBoats();

    void updateBoat(Long id, BoatDTO dto);

    void deleteBoat(Long id);
}