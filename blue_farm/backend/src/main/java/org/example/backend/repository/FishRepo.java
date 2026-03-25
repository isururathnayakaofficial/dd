package org.example.backend.repository;

import org.example.backend.entity.Fish;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FishRepo extends JpaRepository<Fish,Long> {
}