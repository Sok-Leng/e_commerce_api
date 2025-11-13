package com.example.e_commerce_api.controllers;

import com.example.e_commerce_api.dto.response.MessageResponse;
import com.example.e_commerce_api.entities.User;
import com.example.e_commerce_api.exceptions.ApiException;
import com.example.e_commerce_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
public class UserController {
    private final UserService userService;

    @GetMapping("/users")
    public ResponseEntity<MessageResponse> getUser() {
        try {
            var userList = userService.getAllUser();
            return new ResponseEntity<>(
                    new MessageResponse<>("200", "Get all users success", userList, true), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(
                    new MessageResponse<>(e.getCode(), e.getMessage(), null, true), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(
                    new MessageResponse<>("500", "Get all users success", null, true), HttpStatus.OK);
        }
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<MessageResponse> getUserById(@PathVariable("id") int id) {
        try {
            var user = userService.getUserById(id);
            return new ResponseEntity<>(
                    new MessageResponse<>("200", "Get users by id success", user, true), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(
                    new MessageResponse<>(e.getCode(), e.getMessage(), null, true), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(
                    new MessageResponse<>("500", "Failed users by id success", null, true), HttpStatus.OK);
        }
    }

    @PostMapping("/users/create")
    public ResponseEntity<MessageResponse> createUser(@RequestBody User user) {
        try {
            userService.createUser(user);
            return new ResponseEntity<>(
                    new MessageResponse<>("200", "Create users success", user, true), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(
                    new MessageResponse<>(e.getCode(), e.getMessage(), null, true), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(
                    new MessageResponse<>("500", "Failed users success", null, true), HttpStatus.OK);
        }
    }

    @PostMapping("/users/update")
    public ResponseEntity<MessageResponse> updateUser(@RequestBody User user) {
        try {
            userService.updateUser(user);
            return new ResponseEntity<>(
                    new MessageResponse<>("200", "Update users success", user, true), HttpStatus.OK);
        } catch (ApiException e) {
            return new ResponseEntity<>(
                    new MessageResponse<>(e.getCode(), e.getMessage(), null, true), HttpStatus.OK);
        } catch (Throwable e) {
            return new ResponseEntity<>(
                    new MessageResponse<>("500", "Failed users success", null, true), HttpStatus.OK);
        }
    }

}
