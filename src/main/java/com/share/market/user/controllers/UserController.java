package com.share.market.user.controllers;

import com.share.market.user.entities.User;
import com.share.market.user.services.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/users")
    public ResponseEntity<List<User>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return new ResponseEntity<>(users, HttpStatus.OK);
    }

    @GetMapping("/users/{id}")
    public ResponseEntity<User> getUserDetails(@PathVariable Long id) {
        User user = userService.getUserDetails(id);
        return new ResponseEntity<>(user, HttpStatus.OK);
    }

    @GetMapping("/users/username")
    @ResponseBody
    public ResponseEntity<List<User>> getUserDetailByName(@RequestParam(value = "username") String userName) {
        List<User> userDetailsList = userService.getUserDetailByName(userName);
        return new ResponseEntity<>(userDetailsList, HttpStatus.OK);
    }

    @PostMapping("/users")
    public ResponseEntity<List<User>> saveUserDetail(@RequestBody List<User> users) {
        return new ResponseEntity<>(userService.saveUserDetail(users), HttpStatus.CREATED);
    }
}
