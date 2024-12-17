package com.ebunoluwa.smarteventmanagementadmin.service;

import com.ebunoluwa.smarteventmanagementadmin.dto.UserDto;
import com.ebunoluwa.smarteventmanagementadmin.model.User;
import com.ebunoluwa.smarteventmanagementadmin.repositories.UserRepository;

public class UserServiceImpl implements UserService {

    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User();
        return null;
    }
}
