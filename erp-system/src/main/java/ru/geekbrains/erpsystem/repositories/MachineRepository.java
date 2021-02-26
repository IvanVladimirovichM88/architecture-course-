package ru.geekbrains.erpsystem.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.Machine;

@Repository
public interface MachineRepository extends JpaRepository<Machine,Long> {
}
