package com.ebunoluwa.smarteventmanagementadmin.controller;

//import ch.qos.logback.core.model.Model;
import org.springframework.ui.Model;
import com.ebunoluwa.smarteventmanagementadmin.dto.UserDto;
import com.ebunoluwa.smarteventmanagementadmin.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("/registration")
    public String getRegistrationPage() {
        return "register";
    }

    @PostMapping("/registration")
    public String saveUser(@ModelAttribute("user")UserDto userDto, Model model) {
       userService.save(userDto);
       model.addAttribute("message", userDto);
        return "register";
    }

}
