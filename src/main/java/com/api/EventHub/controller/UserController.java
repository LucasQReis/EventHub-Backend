package com.api.EventHub.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.api.EventHub.model.dto.UserDto;
import com.api.EventHub.service.UserServiceImpl;

import org.springframework.web.bind.annotation.RequestBody;

@RestController
@RequestMapping("/user")
public class UserController implements UserControllerApi {

    @Autowired
    private UserServiceImpl userService;

    // Get all users
    @GetMapping
    public ResponseEntity<List<UserDto>> getAllUser() {
        List<UserDto> users = userService.getAllUser();
        return ResponseEntity.ok(users);
    }

    // Get user by ID
    @GetMapping("/{id}")
    public ResponseEntity<UserDto> getUserById(@PathVariable Long id) {
        UserDto userDto = userService.getUserById(id);
        return ResponseEntity.ok(userDto);
    }

    // Create a new user
    @PostMapping
    public ResponseEntity<UserDto> createUser(@RequestBody UserDto userDto) {
        UserDto createdUser = userService.createUser(userDto);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdUser);
    }

    // Delete user
    @DeleteMapping("/{id}")
    public ResponseEntity<UserDto> deleteUser(@PathVariable Long id) {
        Optional<UserDto> userDeleted = Optional.ofNullable(userService.deleteUser(id));
        return userDeleted.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }

    // Update User
    //TODO - TESTAR
    @PutMapping("/{id}")
    public ResponseEntity<UserDto> updatedUser(
            @PathVariable Long id,
            @RequestBody UserDto userDto) {
        Optional<UserDto> userUpdated = Optional.ofNullable(userService.updateUser(id, userDto));
        return userUpdated.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
