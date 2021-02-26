package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.DrawingRepository;
import ru.geekbrains.erpsystem.services.DrawingService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DrawingServiceImpl implements DrawingService {
    private DrawingRepository drawingRepository;

    public DrawingServiceImpl(DrawingRepository drawingRepository) {
        this.drawingRepository = drawingRepository;
    }

    @Override
    public Drawing insert(Drawing drawing) {
        return drawingRepository.save(drawing);
    }

    @Override
    public Drawing update(Drawing drawing) {

        Drawing updateDrawing = getById(drawing.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE", Drawing.class.getName()));
        updateDrawing.update(drawing);
        return drawingRepository.save(updateDrawing);
    }

    @Override
    public void delete(Long drawingId) {
        Drawing deleteDrawing = getById(drawingId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE", Drawing.class.getName()));
        drawingRepository.delete(deleteDrawing);
    }

    @Override
    public Optional<Drawing> getById(Long drawingId) {
        return drawingRepository.findById(drawingId);
    }

    @Override
    public List<Drawing> getAll() {
        return Collections.unmodifiableList(drawingRepository.findAll());
    }
}
