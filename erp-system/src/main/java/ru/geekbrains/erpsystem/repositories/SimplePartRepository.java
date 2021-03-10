package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.part.SimplePart;

@Repository
public interface SimplePartRepository extends JpaRepository<SimplePart,Long> {
}
