package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.BoatDTO;
import org.example.backend.entity.Boat;
import org.example.backend.entity.impl.BoatEntity;
import org.example.backend.repository.BoatRepo;
import org.example.backend.service.BoatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class BoatServiceImpl implements BoatService {

    private final BoatRepo boatRepo;



    @Override
    public void saveBoat(BoatDTO dto) {
        BoatEntity entity = new BoatEntity();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setCapacity(dto.getCapacity());

        boatRepo.save(entity);

    }

    @Override
    public List<BoatDTO> getAllBoats() {

        return boatRepo.findAll().stream().map(b -> {

            BoatDTO dto = new BoatDTO();
            dto.setName(b.getName());
            dto.setType(b.getType());
            dto.setCapacity(b.getCapacity());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public BoatDTO updateBoat(Long id, BoatDTO dto) {

        BoatEntity entity = boatRepo.findById(id).orElseThrow();

        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setCapacity(dto.getCapacity());

        boatRepo.save(entity);



        return dto;
    }

    @Override
    public void deleteBoat(Long id) {

        boatRepo.deleteById(id);

    }
}