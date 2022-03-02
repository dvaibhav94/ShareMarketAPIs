package com.share.market.user.controllers;

import com.share.market.dtos.ResponseDto;
import com.share.market.user.entities.User;
import com.share.market.user.services.UserService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {

    private final UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping
    public ResponseEntity<ResponseDto<List<User>>> saveUsers(@RequestBody List<User> userList) {
        List<User> users = userService.saveUsers(userList);
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, users));
    }
    
    @GetMapping
    public ResponseEntity<ResponseDto<List<User>>> getAllUsers() {
        List<User> users = userService.getAllUsers();
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, users));
    }

    @GetMapping("/{id}")
    public ResponseEntity<ResponseDto<User>> getUserById(@PathVariable Long id) {
        User user = userService.getUserById(id);
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, user));
    }

    @GetMapping("/username")
    public ResponseEntity<ResponseDto<List<User>>> getUserByName(@RequestParam(value = "username") String userName) {
        List<User> users = userService.getUserByName(userName);
        return ResponseEntity.ok(new ResponseDto<>("Success", 1, users));
    }
}
