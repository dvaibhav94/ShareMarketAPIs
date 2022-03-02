package com.share.market.user.services;

import com.share.market.user.entities.User;
import com.share.market.user.exception.UserNotFoundException;
import com.share.market.user.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Optional;

@Service
public class UserService {


    @Autowired
    private UserRepository userRepository;

    public List<User> getAllUsers() {
        return userRepository.findAll();
    }

    public User getUserDetails(@PathVariable Long id) {
        Optional<User> user = userRepository.findById(id);
        if (user.isPresent()) {
            return user.get();
        }
        throw new UserNotFoundException("User with id " + id  + " does not exist");
    }

    public List<User> getUserDetailByName(@RequestParam(value = "username") String userName) {
        return userRepository.findByUserName(userName);
    }

    public List<User> saveUserDetail(@RequestBody List<User> users) {
        return userRepository.saveAll(users);
    }


}
