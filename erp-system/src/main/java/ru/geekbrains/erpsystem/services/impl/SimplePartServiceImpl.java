package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.part.SimplePart;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.SimplePartRepository;
import ru.geekbrains.erpsystem.services.SimpleOperationService;
import ru.geekbrains.erpsystem.services.SimplePartService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SimplePartServiceImpl implements SimplePartService {
    private SimplePartRepository simplePartRepository;

    public SimplePartServiceImpl(SimplePartRepository simplePartRepository) {
        this.simplePartRepository = simplePartRepository;
    }

    @Override
    public SimplePart insert(SimplePart part) {
        return simplePartRepository.save(part);
    }

    @Override
    public SimplePart update(SimplePart part) {
        SimplePart updatePart = getById(part.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE", SimplePart.class.getName()));
        updatePart.update(part);
        return simplePartRepository.save(updatePart);
    }

    @Override
    public void delete(Long partId) {
        SimplePart deletePart = getById(partId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE",SimplePart.class.getName()));
        simplePartRepository.delete(deletePart);
    }

    @Override
    public Optional<SimplePart> getById(Long partId) {
        return simplePartRepository.findById(partId);
    }

    @Override
    public List<SimplePart> getAll() {
        return Collections.unmodifiableList(simplePartRepository.findAll());
    }
}
