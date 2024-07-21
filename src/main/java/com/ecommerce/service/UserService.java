package com.ecommerce.service;

import com.ecommerce.dto.UserDTO;
import com.ecommerce.entity.User;

public interface UserService {

    String addUser(UserDTO userDto);
    String verifyUser(String userName, String password);
    String verifyUserByPhoneNumber(long phone);
}
