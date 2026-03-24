package org.example.backend.repository;

import org.example.backend.entity.impl.userEntity;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface userRepo extends JpaRepository<userEntity, Long> {

    Optional<userEntity> findByUsername(String username);

    boolean existsByUsername(String username);
}