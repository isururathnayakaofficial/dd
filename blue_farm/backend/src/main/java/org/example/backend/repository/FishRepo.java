package org.example.backend.repository;

import org.example.backend.entity.impl.FishEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepo extends JpaRepository<FishEntity,Long> {
}