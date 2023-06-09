package com.example.secondproject.controller;

import com.example.secondproject.dto.UserDto;
import com.example.secondproject.dto.UserResponseDto;
import com.example.secondproject.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping()
    public ResponseEntity<Object> getUser(Long id) {
        UserResponseDto userResponseDto = userService.getUser(id);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }

    @PostMapping()
    public ResponseEntity<Object> createUser(@RequestBody UserDto userDto) {
        UserResponseDto userResponseDto = userService.saveUser(userDto);
        return ResponseEntity.status(HttpStatus.OK).body(userResponseDto);
    }
}
