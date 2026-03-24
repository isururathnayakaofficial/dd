package org.example.backend.service;

import org.example.backend.dto.impl.logDto;

import java.util.List;

public interface logService {

    logDto saveLog(logDto dto);

    List<logDto> getAllLogs();

    void deleteLog(Long id);
}