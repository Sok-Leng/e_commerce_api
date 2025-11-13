package com.example.e_commerce_api.service.impl;

import com.example.e_commerce_api.entities.User;
import com.example.e_commerce_api.exceptions.ApiException;
import com.example.e_commerce_api.repository.UserRepository;
import com.example.e_commerce_api.service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class UserServiceImpl implements UserService {
    private final UserRepository userRepository;
    @Override
    public List<User> getAllUser() throws ApiException {
        return userRepository.findAll();
    }

    @Override
    public void createUser(User user) throws ApiException {
        var checkUsername = userRepository.findByUsername(user.getUsername());
        if(checkUsername.isPresent()){
            throw new ApiException("400", "Username is already exist");
        }
        userRepository.save(user);
    }

    @Override
    public void updateUser(User user) throws ApiException {
        var checkUser = userRepository.findById(user.getId());
        if(checkUser.isEmpty()){
            throw new ApiException("400", "User not found");
        }
        userRepository.save(user);
    }

    @Override
    public User getUserById(Integer id) throws ApiException {
        return userRepository.findById(id).orElse(null);
    }
}
