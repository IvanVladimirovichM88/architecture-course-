package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.data.DrawingData;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.BilletRepository;
import ru.geekbrains.erpsystem.repositories.DrawingRepository;
import ru.geekbrains.erpsystem.repositories.UserRepository;
import ru.geekbrains.erpsystem.services.DrawingService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class DrawingServiceImpl implements DrawingService {
    private DrawingRepository drawingRepository;
    private UserRepository userRepository;
    private BilletRepository billetRepository;


    public DrawingServiceImpl(DrawingRepository drawingRepository,
                              UserRepository userRepository,
                              BilletRepository billetRepository
    ) {
        this.drawingRepository = drawingRepository;
        this.userRepository = userRepository;
        this.billetRepository = billetRepository;
    }

    @Override
    public Drawing insert(Drawing drawing) {
        return drawingRepository.save(drawing);
    }

    @Override
    public Drawing insert(DrawingData drawingData) {
        Drawing drawing = convertDataToEntity(drawingData);
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
    public Drawing update(DrawingData drawingData) {
        Drawing updateDrawing = updateEntityForData(drawingData);
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


    private Drawing convertDataToEntity(DrawingData drawingData){
        Drawing drawing = new Drawing();

        //for security
        drawingData.setDeveloperUserId(1L);

        drawing.setNumber(drawingData.getNumber());
        drawing.setTitle(drawingData.getTitle());
        drawing.setDeveloper(userRepository.getOne(drawingData.getDeveloperUserId()));
        drawing.setBillet(billetRepository.getOne(drawingData.getBilletId()));

        return drawing;
    }

    private Drawing updateEntityForData(DrawingData drawingData){
        Drawing updateDrawing = getById(drawingData.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE", Drawing.class.getName()));

        //for security
        drawingData.setDeveloperUserId(1L);

        updateDrawing.setNumber(drawingData.getNumber());
        updateDrawing.setTitle(drawingData.getTitle());
        updateDrawing.setDeveloper(userRepository.getOne(drawingData.getDeveloperUserId()));
        updateDrawing.setBillet(billetRepository.getOne(drawingData.getBilletId()));

        return updateDrawing;
    }
}
