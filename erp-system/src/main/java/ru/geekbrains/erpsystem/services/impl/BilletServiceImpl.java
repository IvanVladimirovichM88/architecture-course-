package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.Billet;
import ru.geekbrains.erpsystem.repositories.BilletRepository;
import ru.geekbrains.erpsystem.services.BilletService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class BilletServiceImpl implements BilletService {
    BilletRepository billetRepository;

    public BilletServiceImpl(BilletRepository billetRepository) {
        this.billetRepository = billetRepository;
    }

    @Override
    public Billet insert(Billet billet) {

        return billetRepository.save(billet);
    }

    @Override
    public Billet update(Billet billet) {

        Billet updateBillet = getById(billet.getId()).orElseThrow(()->new RuntimeException("Billet not found"));
        updateBillet.update(billet);
        return billetRepository.save(updateBillet);
    }

    @Override
    public void delete(Long billetId) {
        Billet deleteBillet = getById(billetId)
                .orElseThrow(()->new RuntimeException("this Billet can't delete, Billet not found"));
        billetRepository.delete(deleteBillet);
    }

    @Override
    public Optional<Billet> getById(Long billetId) {
        return billetRepository.findById(billetId);
    }

    @Override
    public List<Billet> getAll() {
        return Collections.unmodifiableList(billetRepository.findAll());
    }
}
