package com.example.springboot3_1_2.controller;



import com.example.springboot3_1_2.entity.User;
import com.example.springboot3_1_2.service.UserService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;



@RequestMapping(value = "/users")
@Controller
public class UserController {
    private final UserService userService;

    @Autowired
    public UserController(UserService userService) {
        this.userService = userService;
    }

    @PostMapping("/save")
    public String saveUser(@ModelAttribute("user")@Valid User user, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "AddUser";
        }
        userService.saveUser(user);
        return "redirect:index";
    }

    @GetMapping("/addUser")
    public String addUser(@ModelAttribute("user") User user) {
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
    public String showEditUser(Model model, @RequestParam(value = "id") long id) {
        model.addAttribute("user", userService.getUserFindById(id));
        return "EditUser";
    }

    @PostMapping("/editUser")
    public String editUser(@ModelAttribute("user") @Valid User user
            , BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "EditUser";
        }
        userService.updateUser(user);
        return "redirect:index";
    }
}
