package com.example.secondproject.service.impl;

import com.example.secondproject.repository.UserRepository;
import com.example.secondproject.service.UserDetailService;
import lombok.RequiredArgsConstructor;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class UserDetailServiceImpl implements UserDetailService {

    private final UserRepository userRepository;

    @Override
    public UserDetails loadUserByUserName(String username) throws UsernameNotFoundException {
        return userRepository.getByUid(username);
    }

    @Override
    public UserDetails loadUserByUsername(String username) {
        return null;
    }
}
