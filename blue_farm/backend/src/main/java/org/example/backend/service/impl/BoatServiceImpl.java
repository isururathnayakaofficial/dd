package org.example.backend.service.impl;

import org.example.backend.dto.impl.BoatDto;
import org.example.backend.entity.impl.BoatEntity;
import org.example.backend.repository.BoatRepo;
import org.example.backend.service.BoatService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class BoatServiceImpl implements BoatService {

    private final BoatRepo boatRepo;

    public BoatServiceImpl(BoatRepo boatRepo){
        this.boatRepo = boatRepo;
    }

    @Override
    public BoatDto saveBoat(BoatDto dto) {

        BoatEntity entity = new BoatEntity();
        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setCapacity(dto.getCapacity());

        boatRepo.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    @Override
    public List<BoatDto> getAllBoats() {

        return boatRepo.findAll().stream().map(b -> {

            BoatDto dto = new BoatDto();
            dto.setId(b.getId());
            dto.setName(b.getName());
            dto.setType(b.getType());
            dto.setCapacity(b.getCapacity());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
    public BoatDto updateBoat(Long id, BoatDto dto) {

        BoatEntity entity = boatRepo.findById(id).orElseThrow();

        entity.setName(dto.getName());
        entity.setType(dto.getType());
        entity.setCapacity(dto.getCapacity());

        boatRepo.save(entity);

        dto.setId(entity.getId());

        return dto;
    }

    @Override
    public void deleteBoat(Long id) {

        boatRepo.deleteById(id);

    }
}