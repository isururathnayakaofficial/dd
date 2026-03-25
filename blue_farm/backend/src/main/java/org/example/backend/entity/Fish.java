package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
public class Fish {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private String type;
    private int quantity;
    @ManyToOne
    @JoinColumn(name = "pond_id")
    private Pond pond;

}
