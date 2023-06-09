package com.example.secondproject.service;

import com.example.secondproject.dto.SignInResultDto;
import com.example.secondproject.dto.SignUpResultDto;

public interface SignService {

    SignUpResultDto signUp(String id, String password, String name, String email, String role);

    SignInResultDto signIn(String id, String password) throws RuntimeException;

}