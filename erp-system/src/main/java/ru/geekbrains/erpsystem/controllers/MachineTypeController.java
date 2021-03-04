package ru.geekbrains.erpsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.entities.MachineType;
import ru.geekbrains.erpsystem.services.MachineTypeService;

@Controller
@RequestMapping("/machineTypes")
public class MachineTypeController {
    private MachineTypeService typeService;

    public MachineTypeController(MachineTypeService typeService) {
        this.typeService = typeService;
    }

    @GetMapping("/all")
    public String showAllMachineTypes(
            Model model
    ){
        model.addAttribute("types", typeService.getAll());
        return "machineTypes";
    }

    @GetMapping("/add")
    public String showAddMachineTypeForm(
            Model model
    ){
        model.addAttribute("newType", new MachineType());
        return "forms/add_machineType_form";
    }

    @PostMapping("/add")
    public String addMachineType(
            @ModelAttribute MachineType newType
    ){
        typeService.insert(newType);
        return "redirect:all";
    }
}
