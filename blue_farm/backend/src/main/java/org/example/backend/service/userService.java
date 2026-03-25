package org.example.backend.service;

import org.example.backend.dto.UserDTO;
import org.example.backend.dto.impl.userDto;

import java.util.List;

public interface userService {

    void saveUser(UserDTO dto);

    List<userDto> getAllUsers();

   void updateUser(Long id, UserDTO dto);

    void deleteUser(Long id);
}