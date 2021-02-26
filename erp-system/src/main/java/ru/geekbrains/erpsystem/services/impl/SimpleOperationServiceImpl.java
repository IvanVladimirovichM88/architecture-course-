package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.operaion.SimpleOperation;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.SimpleOperationRepository;
import ru.geekbrains.erpsystem.services.SimpleOperationService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class SimpleOperationServiceImpl implements SimpleOperationService {
    private SimpleOperationRepository simpleOperationRepository;

    public SimpleOperationServiceImpl(SimpleOperationRepository simpleOperationRepository) {
        this.simpleOperationRepository = simpleOperationRepository;
    }

    @Override
    public SimpleOperation insert(SimpleOperation simpleOperation) {
        return simpleOperationRepository.save(simpleOperation);
    }

    @Override
    public SimpleOperation update(SimpleOperation simpleOperation) {

        SimpleOperation updateOperation = getById(simpleOperation.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE", SimpleOperation.class.getName()));
        updateOperation.update(simpleOperation);
        return simpleOperationRepository.save(updateOperation);
    }

    @Override
    public void delete(Long simpleOperationId) {
        SimpleOperation deleteOperation = getById(simpleOperationId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE",SimpleOperation.class.getName()));
        simpleOperationRepository.delete(deleteOperation);
    }

    @Override
    public Optional<SimpleOperation> getById(Long operationId) {
        return simpleOperationRepository.findById(operationId);
    }

    @Override
    public List<SimpleOperation> getAll() {
        return Collections.unmodifiableList(simpleOperationRepository.findAll());
    }
}
