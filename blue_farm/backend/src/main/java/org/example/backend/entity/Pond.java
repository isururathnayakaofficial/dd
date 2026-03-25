package org.example.backend.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pond {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String location;
    private String size;
    private String type;

    @OneToMany(mappedBy = "pond", cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private List<Fish> fishes;

}
