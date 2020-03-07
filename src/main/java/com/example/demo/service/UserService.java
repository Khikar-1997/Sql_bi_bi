package com.example.demo.service;

import com.example.demo.persistence.model.User;
import com.example.demo.persistence.repositori.UserRepository;
import org.springframework.stereotype.Service;

import javax.validation.constraints.Max;
import java.util.List;
import java.util.Optional;

@Service
public class UserService {
    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public void create(User user) {
        userRepository.save(user);
    }

    public Optional<User> findUserById(Long id) {
        return userRepository.findById(id);
    }

    public List<User> selectAllUsers() {
        return userRepository.findAll();
    }

    public void update(Long id, User user2) {
        User user1 = findUserById(id).get();
        user1.setName(user2.getName());
        user1.setPassword(user2.getName());
        userRepository.save(user1);
    }

    public void delete(Long id) {
        userRepository.deleteById(id);
    }
}
