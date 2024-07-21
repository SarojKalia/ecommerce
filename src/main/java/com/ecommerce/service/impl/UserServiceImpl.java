package com.ecommerce.service.impl;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;
import com.ecommerce.repository.UserRepository;
import com.ecommerce.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public String addUser(UserDTO userDto) {
        User saveUser = mapToUser(userDto);
        userRepository.save(saveUser);
            return "User created Sucessfully";
    }
    @Override
    public String verifyUser(String userName, String password) {
        return null;
    }

    @Override
    public String verifyUserByPhoneNumber(long phone) {
        return null;
    }
    User mapToUser(UserDTO userDto){
        User user = new User();
        user.setUserName(userDto.getUserName());
        user.setUserEmail(userDto.getUserEmail());
        user.setMobile(userDto.getMobile());
        return user;
    }

}
