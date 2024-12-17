package com.ebunoluwa.smarteventmanagementadmin.service;

import com.ebunoluwa.smarteventmanagementadmin.dto.UserDto;
import com.ebunoluwa.smarteventmanagementadmin.model.User;
import org.springframework.stereotype.Service;

@Service
public interface UserService {


    User save (UserDto userDto);

}

