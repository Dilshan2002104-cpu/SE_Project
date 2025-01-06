package com.example.demo.controller;

import com.example.demo.exception.ApiResponse;
import com.example.demo.model.User;
import com.example.demo.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping("/register")
    public ResponseEntity<ApiResponse> register(@RequestBody User user) {
        userService.register(user);
        return ResponseEntity.ok(new ApiResponse("User  registered successfully",null));
    }

    @PostMapping("/login")
    public ResponseEntity<String> login(@RequestBody User user){
        if(userService.login(user.getUsername(),user.getPassword()).isPresent()){
            return ResponseEntity.ok("User logged in successfully");
        }
        return ResponseEntity.status(401).body(("Invalid credentials"));
    }
}

