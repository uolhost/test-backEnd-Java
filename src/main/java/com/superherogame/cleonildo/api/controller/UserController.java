package com.superherogame.cleonildo.api.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.superherogame.cleonildo.api.dto.request.UserRequest;
import com.superherogame.cleonildo.api.dto.response.UserResponse;
import com.superherogame.cleonildo.domain.services.UserService;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
@RequestMapping(value = "/api/v1/client")
public class UserController {
    private final UserService service;

    public UserController(UserService service) {
        this.service = service;
    }

    @GetMapping
    public ResponseEntity<Page<UserResponse>> getAllUsers(Pageable pageable) {
        Page<UserResponse> response = service.getAllUser(pageable);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @GetMapping("/{id}")
    public ResponseEntity<UserResponse> getUserById(@PathVariable("id") UUID id) {
        UserResponse response = service.getUserById(id);
        return ResponseEntity.status(HttpStatus.OK).body(response);
    }

    @PostMapping("/add")
    public ResponseEntity<UserResponse> saveClient(@RequestBody UserRequest request) {
        UserResponse response = service.addUser(request);
        return ResponseEntity.status(HttpStatus.CREATED).body(response);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<Void> updateUser(@PathVariable("id") UUID id, @RequestBody UserRequest request) {
        service.updateUser(id, request);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }

    @DeleteMapping("delete/{id}")
    public ResponseEntity<Void> deleteUserById(@PathVariable("id") UUID id) {
        service.deleteUserById(id);
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
