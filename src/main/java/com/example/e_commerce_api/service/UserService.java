package com.example.e_commerce_api.service;

import com.example.e_commerce_api.entities.User;
import com.example.e_commerce_api.exceptions.ApiException;

import java.util.List;

public interface UserService {
    List<User> getAllUser() throws ApiException;

    void createUser(User user) throws ApiException;
    void updateUser(User user) throws ApiException;
    User getUserById(Integer id) throws ApiException;
}
