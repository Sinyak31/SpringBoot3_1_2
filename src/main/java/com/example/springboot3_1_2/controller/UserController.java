package org.example.controller;

import org.example.entity.User;
import org.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;


@RequestMapping(value = "/users")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user") User user) {
        userService.saveUser(user);
        return "redirect:index";
    }

    @GetMapping("/addUser")
    public String addUser() {
        return "AddUser";
    }

    @GetMapping("/index")
    public String getUsers(Model model) {
        model.addAttribute("usersList", userService.getUserList());
        return "Users";
    }

    @GetMapping(value = "/remove")
    public String removeUser(@RequestParam(value = "id") long id) {
        userService.removeUser(id);
        return "redirect:index";
    }

    @GetMapping("/edit")
    public String showEditUser(@RequestParam(value = "id") long id, Model model) {
        model.addAttribute("user", userService.getUserFindById(id));
        return "EditUser";
    }

    @PostMapping("/editUser")
    public String editUser(@RequestParam(value = "id") long id, @ModelAttribute("user") User user) {
        userService.updateUser(id, user);
        return "redirect:index";
    }
}
