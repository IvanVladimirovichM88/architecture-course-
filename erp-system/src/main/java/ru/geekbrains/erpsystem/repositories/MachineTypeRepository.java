package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.MachineType;

@Repository
public interface MachineTypeRepository extends JpaRepository<MachineType, Long> {
}
