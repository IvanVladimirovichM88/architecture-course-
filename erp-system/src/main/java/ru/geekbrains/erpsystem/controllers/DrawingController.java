package ru.geekbrains.erpsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.data.DrawingData;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.services.BilletService;
import ru.geekbrains.erpsystem.services.DrawingService;

@Controller
@RequestMapping("/drawings")
public class DrawingController {
    private DrawingService drawingService;
    private BilletService billetService;

    public DrawingController(
            DrawingService drawingService,
            BilletService billetService
    ) {
        this.drawingService = drawingService;
        this.billetService = billetService;
    }

    @GetMapping("/all")
    public String showAllDrawings(
            Model model
    ){
        model.addAttribute("drawings", drawingService.getAll());
        return "drawings";
    }

    @GetMapping("/add")
    public String showAddDrawingForm(
            Model model
    ){
        model.addAttribute("newDrawing", new DrawingData());
        model.addAttribute("allBillets", billetService.getAll());
        return "forms/add_drawing_form";
    }

    @PostMapping("/add")
    public String addDrawing(
            @ModelAttribute DrawingData newDrawing
    ){
        drawingService.insert(newDrawing);
        return "redirect:all";
    }
}
