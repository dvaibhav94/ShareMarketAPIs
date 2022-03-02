package com.share.market.user.services;

import com.share.market.dtos.ResponseDto;
import com.share.market.user.entities.User;
import com.share.market.exception.ValidationException;
import com.share.market.user.repositories.UserRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {

    private final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    public List<User> saveUsers(@RequestBody List<User> users) {
        return userRepository.saveAll(users);
    }

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserById(@PathVariable Long id) {
        return userRepository.findById(id)
                .orElseThrow(() -> new ValidationException("User not found with id: " + id));
    }

    public List<User> getUserByName(@RequestParam(value = "username") String userName) {
        return userRepository.findByUserName(userName);
    }

}
