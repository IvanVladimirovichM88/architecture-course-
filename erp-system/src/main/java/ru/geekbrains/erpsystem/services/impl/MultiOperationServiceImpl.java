package ru.geekbrains.erpsystem.services.impl;

import ru.geekbrains.erpsystem.entities.operaion.MultiOperation;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.MultiOperationRepository;
import ru.geekbrains.erpsystem.services.MultiOperationService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class MultiOperationServiceImpl implements MultiOperationService {
    MultiOperationRepository multiOperationRepository;

    public MultiOperationServiceImpl(MultiOperationRepository multiOperationRepository) {
        this.multiOperationRepository = multiOperationRepository;
    }

    @Override
    public MultiOperation insert(MultiOperation multiOperation) {
        return multiOperationRepository.save(multiOperation);
    }

    @Override
    public MultiOperation update(MultiOperation multiOperation) {

        MultiOperation updateMultiOperation = getById(multiOperation.getId())
                .orElseThrow(()-> new ResourceNotFoundException("UPDATE", MultiOperation.class.getName()));
        updateMultiOperation.update(multiOperation);
        return multiOperationRepository.save(updateMultiOperation);
    }

    @Override
    public void delete(Long multiOperationId) {
        MultiOperation deleteMultiOperation = getById(multiOperationId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE", MultiOperation.class.getName()));
    }

    @Override
    public Optional<MultiOperation> getById(Long multiOperationId) {
        return multiOperationRepository.findById(multiOperationId);
    }

    @Override
    public List<MultiOperation> getAll() {
        return Collections.unmodifiableList(multiOperationRepository.findAll());
    }
}
