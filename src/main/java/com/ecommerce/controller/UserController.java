package com.ecommerce.controller;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/v1/User")
public class UserController {

    @Autowired
    private UserService userService;

    @PostMapping
    ResponseEntity<String> saveUser(UserDTO userDTO){
        return new ResponseEntity<>(userService.addUser(userDTO), HttpStatus.CREATED);
    }
}
