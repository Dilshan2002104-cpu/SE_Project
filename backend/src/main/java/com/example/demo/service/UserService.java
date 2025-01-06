package com.example.demo.service;

import com.example.demo.Repository.UserRepository;
import com.example.demo.exception.EmailAlreadyExistsException;
import com.example.demo.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class UserService {

    @Autowired
    private UserRepository userRepository;

    private final BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();

    public User register(User user) {
        if(userRepository.findByEmail(user.getEmail()).isPresent()) {
            throw new EmailAlreadyExistsException("Email already exists");
        }
        user.setPassword(passwordEncoder.encode(user.getPassword()));
        return userRepository.save(user);
    }

    public Optional<User> login(String username , String password){
        Optional<User> user = userRepository.findByUsername(username);
        if(user.isPresent() && passwordEncoder.matches(password,user.get().getPassword())){
            return user;
        }
        return Optional.empty();
    }
}
