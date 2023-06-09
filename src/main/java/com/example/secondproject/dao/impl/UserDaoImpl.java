package com.example.secondproject.dao.impl;

import com.example.secondproject.dao.UserDao;
import com.example.secondproject.entity.User;
import com.example.secondproject.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class UserDaoImpl implements UserDao {
    public final UserRepository userRepository;

    @Autowired
    public UserDaoImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }


    @Override
    public User insertUser(User user) {
        User saveUser = userRepository.save(user);
        return saveUser;
    }

    @Override
    public User selectUser(Long id) {
        User selectUser = userRepository.getReferenceById(id);
        return selectUser;
    }
}
