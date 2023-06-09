package com.example.secondproject.dao;

import com.example.secondproject.entity.User;

public interface UserDao {
    User insertUser(User user);
    User selectUser(Long id);
}
