package org.example.backend.controller;

import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.example.backend.dto.FishDTO;
import org.example.backend.dto.impl.FishDto;
import org.example.backend.service.FishService;
import org.example.backend.util.APIResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/app/v1/fish")
@CrossOrigin
@RequiredArgsConstructor
public class FishController {

    private final FishService fishService;

    @PostMapping("/save")
    public ResponseEntity<APIResponse<String>> saveFish(
            @RequestBody FishDTO fishDto) {

        fishService.saveFish(fishDto);

        return ResponseEntity.status(HttpStatus.CREATED)
                .body(new APIResponse<>(
                        201,
                        "Fish saved successfully",
                        null
                ));
    }

    @PutMapping
    public ResponseEntity<APIResponse<String>> updateFish(
            @RequestBody @Valid FishDto fishDto) {

        fishService.updateFish(fishDto);  // ← getId() remove, dto only pass

        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Fish updated successfully",
                        null
                )
        );
    }
    @GetMapping
    public ResponseEntity<APIResponse<List<FishDto>>> getAllFish() {

        List<FishDto> fishList = fishService.getAllFish();

        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Fish list fetched",
                        fishList
                )
        );
    }

    @GetMapping("/{id}")
    public ResponseEntity<APIResponse<FishDto>> getFish(
            @PathVariable Long id) {

        FishDto fish = fishService.getFish(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Fish fetched",
                        fish
                )
        );
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<APIResponse<String>> deleteFish(
            @PathVariable Long id) {

        fishService.deleteFish(id);

        return ResponseEntity.ok(
                new APIResponse<>(
                        200,
                        "Fish deleted successfully",
                        null
                )
        );
    }
}