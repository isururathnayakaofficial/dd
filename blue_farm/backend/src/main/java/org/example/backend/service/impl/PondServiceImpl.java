package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.PondDTO;
import org.example.backend.dto.impl.PondDto;
import org.example.backend.entity.impl.PondEntity;
import org.example.backend.repository.PondRepo;
import org.example.backend.service.PondService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class PondServiceImpl implements PondService {

    private final PondRepo pondRepo;

    @Override
    public void savePond(PondDTO dto) {

        PondEntity entity = new PondEntity();
        entity.setLocation(dto.getLocation());
        entity.setSize(dto.getSize());
        entity.setType(dto.getType());

        pondRepo.save(entity);
    }

    @Override
    public List<PondDto> getAllPonds() {

        return pondRepo.findAll().stream().map(p -> {

            PondDto dto = new PondDto();
            dto.setId(p.getId());
            dto.setLocation(p.getLocation());
            dto.setSize(p.getSize());
            dto.setType(p.getType());

            return dto;

        }).collect(Collectors.toList());
    }

    @Override
            public void updatePond(Long id, PondDTO dto) {

        PondEntity entity = pondRepo.findById(id).orElseThrow();

        entity.setLocation(dto.getLocation());
        entity.setSize(dto.getSize());
        entity.setType(dto.getType());

        pondRepo.save(entity);

    }

    @Override
    public void deletePond(Long id) {

        pondRepo.deleteById(id);

    }
}