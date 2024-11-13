package com.springboot.adakita.adakita.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.springboot.adakita.adakita.entity.User;
import com.springboot.adakita.adakita.repository.UserRepository;
import java.util.List;

@Service
public class UserService {

    @Autowired
    UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(int user_id) {
        return userRepository.findById(user_id).orElse(null);
    }

    public User addUser(User user) {
        return userRepository.save(user);
    }

    public User updateUser(int user_id, User user) {
        user.setId(user_id);
        return userRepository.save(user);
    }

    public void deleteUser(int user_id) {
        userRepository.deleteById(user_id);
    }
}

