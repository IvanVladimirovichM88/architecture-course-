package ru.geekbrains.erpsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.data.UserData;
import ru.geekbrains.erpsystem.entities.User;
import ru.geekbrains.erpsystem.services.RoleService;
import ru.geekbrains.erpsystem.services.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

    private UserService userService;
    private RoleService roleService;

    public UserController(UserService userService, RoleService roleService) {
        this.userService = userService;
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String showAllUsers(
            Model model
    ){
        model.addAttribute("users", userService.getAll()) ;
        return "users";
    }

    @GetMapping("/add")
    public String getAddUserForm(
            Model model
    ){
        model.addAttribute("user", new UserData());
        model.addAttribute("allRoles", roleService.getAll());
        return "forms/add_user_form";
    }

    @PostMapping("/add")
    public String addUser(
            @ModelAttribute UserData userData
    ){
        userService.insert(userData);
        return "redirect:all";
    }


}
