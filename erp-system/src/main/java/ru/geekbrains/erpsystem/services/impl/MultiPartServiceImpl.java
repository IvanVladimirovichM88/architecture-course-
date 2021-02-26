package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.part.MultiPart;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.MultiPartRepository;
import ru.geekbrains.erpsystem.services.MultiPartService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MultiPartServiceImpl implements MultiPartService {
    MultiPartRepository multiPartRepository;

    public MultiPartServiceImpl(MultiPartRepository multiPartRepository) {
        this.multiPartRepository = multiPartRepository;
    }

    @Override
    public MultiPart insert(MultiPart multiPart) {
        return multiPartRepository.save(multiPart);
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
