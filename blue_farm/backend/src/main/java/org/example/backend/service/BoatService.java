package org.example.backend.service;

import org.example.backend.dto.impl.BoatDto;

import java.util.List;

public interface BoatService {

    BoatDto saveBoat(BoatDto dto);

    List<BoatDto> getAllBoats();

    BoatDto updateBoat(Long id, BoatDto dto);

    void deleteBoat(Long id);
}