package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.impl.FishDto;
import org.example.backend.entity.impl.FishEntity;
import org.example.backend.exception.BadRequestException;
import org.example.backend.exception.ResourceNotFoundException;
import org.example.backend.repository.FishRepo;
import org.example.backend.service.FishService;
import org.modelmapper.ModelMapper;
import org.modelmapper.TypeToken;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Service
@RequiredArgsConstructor
@Transactional
public class FishServiceImpl implements FishService {

    private final FishRepo fishRepo;
    private final ModelMapper modelMapper;

    @Override
    public void saveFish(FishDto dto) {

        if (dto == null) {
            throw new BadRequestException("Request body is missing");
        }

        fishRepo.save(modelMapper.map(dto, FishEntity.class));
    }

    @Override
    public void updateFish(FishDto dto) {

        if (dto == null) {
            throw new BadRequestException("Request body is missing");
        }

        if (dto.getId() == null) {
            throw new BadRequestException("Fish ID is required for update");
        }

        FishEntity existing = fishRepo.findById(dto.getId())
                .orElseThrow(() ->
                        new ResourceNotFoundException("Fish not found")
                );

        existing.setName(dto.getName());
        existing.setType(dto.getType());
        existing.setQuantity(dto.getQuantity());
    }

    @Override
    public List<FishDto> getAllFish() {

        List<FishEntity> fishList = fishRepo.findAll();

        return modelMapper.map(
                fishList,
                new TypeToken<List<FishDto>>() {}.getType()
        );
    }

    @Override
    public FishDto getFish(Long id) {

        FishEntity fish = fishRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Fish not found")
                );

        return modelMapper.map(fish, FishDto.class);
    }

    @Override
    public void deleteFish(Long id) {

        if (!fishRepo.existsById(id)) {
            throw new ResourceNotFoundException("Fish not found");
        }

        fishRepo.deleteById(id);
    }
}