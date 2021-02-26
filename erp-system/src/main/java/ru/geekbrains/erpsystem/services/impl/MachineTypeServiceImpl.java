package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.MachineType;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.MachineTypeRepository;
import ru.geekbrains.erpsystem.services.MachineTypeService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class MachineTypeServiceImpl implements MachineTypeService {

    MachineTypeRepository machineTypeRepository;

    public MachineTypeServiceImpl(MachineTypeRepository machineTypeRepository) {
        this.machineTypeRepository = machineTypeRepository;
    }

    @Override
    public MachineType insert(MachineType machineType) {
        return machineTypeRepository.save(machineType);
    }

    @Override
    public MachineType update(MachineType machineType) {
        MachineType updateMachineType = getById(machineType.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE", MachineType.class.getName()));
        updateMachineType.update(machineType);

        return machineTypeRepository.save(updateMachineType);
    }

    @Override
    public void delete(Long machineTypeId) {
        MachineType deleteMachineType = getById(machineTypeId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE", MachineType.class.getName()));
        machineTypeRepository.delete(deleteMachineType);
    }

    @Override
    public Optional<MachineType> getById(Long machineTypeId) {
        return machineTypeRepository.findById(machineTypeId);
    }

    @Override
    public List<MachineType> getAll() {
        return Collections.unmodifiableList(machineTypeRepository.findAll());
    }
}
