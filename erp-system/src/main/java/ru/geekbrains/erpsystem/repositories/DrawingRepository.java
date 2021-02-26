package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.Drawing;

@Repository
public interface DrawingRepository extends JpaRepository<Drawing,Long> {
}
