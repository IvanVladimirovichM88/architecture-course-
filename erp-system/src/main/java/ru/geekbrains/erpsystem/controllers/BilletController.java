package ru.geekbrains.erpsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.entities.Billet;
import ru.geekbrains.erpsystem.services.BilletService;

@Controller
@RequestMapping("/billets")
public class BilletController {
    private BilletService billetService;

    public BilletController(BilletService billetService) {
        this.billetService = billetService;
    }

    @GetMapping("/all")
    public String showAllBillets(
            Model model
    ){
        model.addAttribute("billets", billetService.getAll());
        return "billets";
    }

    @GetMapping("/add")
    public String ShowAddBilletForm(
            Model model
    ){
        model.addAttribute("newBillet", new Billet());
        return "forms/add_billet_form";
    }

    @PostMapping("/add")
    public String addBillet(
            @ModelAttribute Billet newBillet
    ){
        billetService.insert(newBillet);
        return "redirect:all";
    }
}
