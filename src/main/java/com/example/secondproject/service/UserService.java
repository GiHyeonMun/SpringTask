package com.example.secondproject.service;

import com.example.secondproject.dto.UserDto;
import com.example.secondproject.dto.UserResponseDto;

public interface UserService {
    UserResponseDto getUser(Long id);
    UserResponseDto saveUser(UserDto userDto);
}
