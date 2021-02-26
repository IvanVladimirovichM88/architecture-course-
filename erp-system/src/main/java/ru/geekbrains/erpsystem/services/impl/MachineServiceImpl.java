package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.Machine;
import ru.geekbrains.erpsystem.repositories.MachineRepository;
import ru.geekbrains.erpsystem.services.MachineService;

import java.util.List;
import java.util.Optional;

@Service
public class MachineServiceImpl implements MachineService {

    MachineRepository machineRepository;

    public MachineServiceImpl(MachineRepository machineRepository) {
        this.machineRepository = machineRepository;
    }

    @Override
    public Machine insert(Machine var1) {
        return null;
    }

    @Override
    public Machine update(Machine var1) {
        return null;
    }

    @Override
    public void delete(Long var1) {

    }

    @Override
    public Optional<Machine> getById(Long var1) {
        return Optional.empty();
    }

    @Override
    public List<Machine> getAll() {
        return null;
    }
}
