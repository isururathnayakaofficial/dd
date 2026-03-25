package org.example.backend.service.impl;

import lombok.RequiredArgsConstructor;
import org.example.backend.dto.FishDTO;
import org.example.backend.dto.impl.FishDto;
import org.example.backend.entity.Fish;
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
    public void saveFish(FishDTO dto) {

        if (dto == null) {
            throw new BadRequestException("Request body is missing");
        }
        Fish fish =new Fish();
        fish.setName(dto.getName());
        fish.setType(dto.getType());
        fish.setQuantity(dto.getQuantity());
        fishRepo.save(fish);
    }

    @Override
    public void updateFish(FishDTO dto,Long id) {

        if (dto == null) {
            throw new BadRequestException("Request body is missing");
        }


        Fish existing = fishRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Fish not found")
                );

        existing.setName(dto.getName());
        existing.setType(dto.getType());
        existing.setQuantity(dto.getQuantity());
    }

    @Override
    public List<FishDto> getAllFish() {

        List<Fish> fishList = fishRepo.findAll();

        return modelMapper.map(
                fishList,
                new TypeToken<List<FishDto>>() {}.getType()
        );
    }

    @Override
    public Fish getFish(Long id) {

        Fish fish = fishRepo.findById(id)
                .orElseThrow(() ->
                        new ResourceNotFoundException("Fish not found")
                );

        fishRepo.delete(fish);
        return fish;
    }

    @Override
    public void deleteFish(Long id) {

        if (!fishRepo.existsById(id)) {
            throw new ResourceNotFoundException("Fish not found");
        }

        fishRepo.deleteById(id);
    }
}