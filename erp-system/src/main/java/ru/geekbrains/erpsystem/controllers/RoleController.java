package ru.geekbrains.erpsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.entities.Role;
import ru.geekbrains.erpsystem.services.RoleService;

@Controller
@RequestMapping("/roles")
public class RoleController {
    private RoleService roleService;

    public RoleController(RoleService roleService) {
        this.roleService = roleService;
    }

    @GetMapping("/all")
    public String showAllRoles(
            Model model
    ){
        model.addAttribute("roles", roleService.getAll());
        return "roles";
    }

    @GetMapping("/add")
    public String getAddRoleForm(
            Model model
    ){
        model.addAttribute("newRole", new Role());
        return "forms/add_role_form";
    }
    @PostMapping("/add")
    public String addRole(
            @ModelAttribute Role newRole
    ){
        roleService.insert(newRole);
        return "redirect:all";
    }

}
