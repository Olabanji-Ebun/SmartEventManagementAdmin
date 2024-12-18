package com.ebunoluwa.smarteventmanagementadmin.service;

import com.ebunoluwa.smarteventmanagementadmin.dto.UserDto;
import com.ebunoluwa.smarteventmanagementadmin.model.User;
import com.ebunoluwa.smarteventmanagementadmin.repositories.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private PasswordEncoder passwordEncoder;

    @Autowired
    private UserRepository userRepository;

    @Override
    public User save(UserDto userDto) {
        User user = new User(userDto.getEmail(),passwordEncoder.encode(userDto.getPassword()) , userDto.getRole(), userDto.getFullname());
        return userRepository.save(user);
    }
}
