package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.part.MultiPart;

@Repository
public interface MultiPartRepository extends JpaRepository<MultiPart, Long> {
}
