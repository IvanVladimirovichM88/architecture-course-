package ru.geekbrains.erpsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.entities.Machine;
import ru.geekbrains.erpsystem.repositories.MachineRepository;
import ru.geekbrains.erpsystem.repositories.MachineTypeRepository;

@Controller
@RequestMapping("/machines")
public class MachineController {
    private MachineRepository machineRepository;
    private MachineTypeRepository typeRepository;

    public MachineController(
            MachineRepository machineRepository,
            MachineTypeRepository typeRepository
    ) {
        this.machineRepository = machineRepository;
        this.typeRepository = typeRepository;
    }

    @GetMapping("/all")
    public String showAllMachine(
            Model model
    ){
        model.addAttribute("machines", machineRepository.findAll());
        return "machines";
    }

    @GetMapping("/add")
    public String showAddMachineForm(
            Model model
    ){
        model.addAttribute("newMachine", new Machine());
        model.addAttribute("allTypes", typeRepository.findAll());
        return "forms/add_machine_form";
    }

    @PostMapping("/add")
    public String addMachine(
            @ModelAttribute Machine newMachine
    ){
        machineRepository.save(newMachine);
        return "redirect:all";
    }
}
