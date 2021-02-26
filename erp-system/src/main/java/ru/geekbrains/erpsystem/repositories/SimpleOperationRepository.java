package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.operaion.SimpleOperation;

@Repository
public interface SimpleOperationRepository extends JpaRepository<SimpleOperation,Long> {
}
