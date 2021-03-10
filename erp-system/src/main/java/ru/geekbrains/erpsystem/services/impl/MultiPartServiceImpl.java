package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.data.MultiPartData;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.part.MultiPart;
import ru.geekbrains.erpsystem.entities.part.SimplePart;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.DrawingRepository;
import ru.geekbrains.erpsystem.repositories.MultiPartRepository;
import ru.geekbrains.erpsystem.repositories.SimplePartRepository;
import ru.geekbrains.erpsystem.services.MultiPartService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MultiPartServiceImpl implements MultiPartService {
    private MultiPartRepository multiPartRepository;
    private SimplePartRepository simplePartRepository;
    private DrawingRepository drawingRepository;

    public MultiPartServiceImpl(
            MultiPartRepository multiPartRepository,
            SimplePartRepository simplePartRepository,
            DrawingRepository drawingRepository
    ) {
        this.multiPartRepository = multiPartRepository;
        this.simplePartRepository = simplePartRepository;
        this.drawingRepository = drawingRepository;
    }

    @Override
    public MultiPart insert(MultiPart multiPart) {
        return multiPartRepository.save(multiPart);
    }

    @Override
    public MultiPart insert(MultiPartData multiPartData) {

        Drawing multiPartDrawing = drawingRepository.findById(multiPartData.getDrawingId())
                .orElseThrow(()->new ResourceNotFoundException("INSERT",Drawing.class.getName()));

        List<SimplePart> subSimplePart = multiPartData.getSimplePartsId().stream()
                .map(simplePartId->simplePartRepository.findById(simplePartId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        List<MultiPart> subMultiPart = multiPartData.getMultiPartsId().stream()
                .map(multiPartId -> multiPartRepository.findById(multiPartId))
                .filter(Optional::isPresent)
                .map(Optional::get)
                .collect(Collectors.toList());

        return multiPartRepository.save( new MultiPart(multiPartDrawing, subSimplePart, subMultiPart) ) ;

    }

    @Override
    public MultiPart update(MultiPart multiPart) {
        MultiPart updateMultiPart = multiPartRepository.findById(multiPart.getId())
                .orElseThrow(()-> new ResourceNotFoundException("UPDATE",MultiPart.class.getName()));
        updateMultiPart.update(multiPart);

        return multiPartRepository.save(updateMultiPart);
    }

    @Override
    public void delete(Long multiPartId) {
        MultiPart deleteMultiPart = multiPartRepository.findById(multiPartId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE", MultiPart.class.getName()));
        multiPartRepository.delete(deleteMultiPart);
    }

    @Override
    public Optional<MultiPart> getById(Long multiPartId) {
        return multiPartRepository.findById(multiPartId);
    }

    @Override
    public List<MultiPart> getAll() {
        return Collections.unmodifiableList(multiPartRepository.findAll());
    }
}
