package org.example.backend.repository;

import org.example.backend.entity.impl.staffEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface staffRepo extends JpaRepository<staffEntity, Long> {
}