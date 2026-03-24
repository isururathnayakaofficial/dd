package org.example.backend.dto.impl;

import jakarta.annotation.Nullable;
import jakarta.validation.constraints.*;
import lombok.*;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
public class FishDto {

    @Nullable
    private Long id;

    @NotBlank(message = "Fish name is mandatory")
    @Size(
            min = 2,
            max = 50,
            message = "Fish name must be between 2 and 50 characters"
    )
    @Pattern(
            regexp = "^[A-Za-z ]+$",
            message = "Fish name must contain only letters and spaces"
    )
    private String name;

    @NotBlank(message = "Fish type is mandatory")
    @Size(
            min = 2,
            max = 50,
            message = "Fish type must be between 2 and 50 characters"
    )
    @Pattern(
            regexp = "^[A-Za-z ]+$",
            message = "Fish type must contain only letters and spaces"
    )
    private String type;

    @Min(
            value = 1,
            message = "Quantity must be at least 1"
    )
    @Max(
            value = 100000,
            message = "Quantity cannot exceed 100000"
    )
    private int quantity;
}