package ru.geekbrains.erpsystem.controllers;

import net.bytebuddy.asm.Advice;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.geekbrains.erpsystem.data.MultiPartData;
import ru.geekbrains.erpsystem.data.SimplePartData;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.part.SimplePart;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.services.DrawingService;
import ru.geekbrains.erpsystem.services.MultiPartService;
import ru.geekbrains.erpsystem.services.SimplePartService;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Controller
@RequestMapping("/parts")
public class PartController {

    private MultiPartService multiPartService;
    private SimplePartService simplePartService;
    private DrawingService drawingService;

    public PartController(
            MultiPartService multiPartService,
            SimplePartService simplePartService,
            DrawingService drawingService
    ) {
        this.multiPartService = multiPartService;
        this.simplePartService = simplePartService;
        this.drawingService = drawingService;
    }

    @GetMapping("/multi/all")
    public String ShowAllMultiParts(
            Model model
    ){
        model.addAttribute("parts", multiPartService.getAll());
        model.addAttribute("typePart", "multi");
        return "parts";
    }

    @GetMapping("/simple/all")
    public String ShowAllSimpleParts(
            Model model
    ){
        model.addAttribute("parts", simplePartService.getAll());
        model.addAttribute("typePart", "simple");
        return "parts";
    }

    @GetMapping("simple/add")
    public String getSimplePartsAddForm(
            Model model
    ){
        model.addAttribute("part", new SimplePartData());
        model.addAttribute("allDrawings", drawingService.getAll());
        return "forms/add_simple_part_form";
    }

    @PostMapping("simple/add")
    public String addSimplePart(
            @ModelAttribute SimplePartData simplePartData
    ){
        simplePartService.insert(simplePartData);

        return "redirect:all";
    }

    @GetMapping("multi/add")
    public String getMultiPartAddForm(
            Model model
    ){
        model.addAttribute("part", new MultiPartData());
        model.addAttribute("allDrawings", drawingService.getAll() );
        model.addAttribute("allMultiParts", multiPartService.getAll());
        model.addAttribute("allSimpleParts", simplePartService.getAll().stream().map(SimplePartData::new).collect(Collectors.toList()) );

        return "forms/add_multi_part_form";
    }

    @PostMapping("multi/add")
    public String addMultiPart(
            @ModelAttribute MultiPartData multiPartData
    ){
        multiPartService.insert(multiPartData);

        return "redirect:all";
    }
}
