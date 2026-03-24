package org.example.backend.repository;

import org.example.backend.entity.impl.PondEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PondRepo extends JpaRepository<PondEntity, Long> {

}