package com.example.demo.controller;

import com.example.demo.persistence.model.User;
import com.example.demo.service.UserService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class Controller {
    private final UserService userService;

    public Controller(UserService userService) {
        this.userService = userService;
    }

    @PostMapping(value = "/user")
    public void create(@RequestBody User user){
        userService.create(user);
    }

    @GetMapping(value = "/user")
    public ResponseEntity<List<User>> selectAllUsers(){
        List<User> users = userService.selectAllUsers();
        return ResponseEntity.ok(users);
    }

    @GetMapping(value = "/user/{id}")
    public ResponseEntity<Optional<User>> findUserById(@PathVariable Long id){
        Optional<User> user = userService.findUserById(id);
        return ResponseEntity.ok(user);
    }

    @PutMapping(value = "/user/{id}")
    public ResponseEntity update(@PathVariable Long id,@RequestBody User user){
        userService.update(id,user);
        return (ResponseEntity) ResponseEntity.ok();
    }

    @DeleteMapping(value = "/user/{id}")
    public void delete(@PathVariable Long id){
        userService.delete(id);
    }
}
