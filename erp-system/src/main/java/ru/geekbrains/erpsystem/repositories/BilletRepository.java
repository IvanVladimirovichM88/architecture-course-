package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.Billet;

@Repository
public interface BilletRepository extends JpaRepository<Billet, Long> {
}
