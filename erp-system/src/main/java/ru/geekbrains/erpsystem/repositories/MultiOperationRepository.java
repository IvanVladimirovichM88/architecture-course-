package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.operaion.MultiOperation;

@Repository
public interface MultiOperationRepository extends JpaRepository<MultiOperation,Long> {
}
