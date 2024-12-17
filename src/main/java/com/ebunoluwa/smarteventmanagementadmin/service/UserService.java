package com.ebunoluwa.smarteventmanagementadmin.service;

import com.ebunoluwa.smarteventmanagementadmin.dto.UserDto;
import com.ebunoluwa.smarteventmanagementadmin.model.User;

public interface UserService {

    User save (UserDto userDto);

}

