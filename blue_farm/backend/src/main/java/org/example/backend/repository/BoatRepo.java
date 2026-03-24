package org.example.backend.repository;

import org.example.backend.entity.impl.BoatEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface BoatRepo extends JpaRepository<BoatEntity, Long> {
}