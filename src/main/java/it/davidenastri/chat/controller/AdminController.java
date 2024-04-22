package it.davidenastri.chat.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import it.davidenastri.chat.model.User;
import it.davidenastri.chat.service.UserService;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
@RequestMapping("/admin")
public class AdminController {

    UserService userService;

    public AdminController(UserService userService) {
        this.userService = userService;
    }
    
    @GetMapping()
    public String adminView(Model model) {
        System.out.println("HEEEERE IS USERSSSSSSSSS"+userService.getUsers());
        // model.addAttribute("user", new User(1, "gae", "dfd", "bruh", "a"," b"));
        model.addAttribute("users", userService.getUsers());
        return "admin";
    }
    
    @PostMapping("/deleteUser")
    public String deleteUser(User user, Model model) {
        System.out.println(user.getUsername());
        userService.deleteUser(user.getUsername());
        model.addAttribute("users", userService.getUsers());
        return "redirect:/admin";
    }
}
