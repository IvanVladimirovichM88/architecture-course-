package ru.geekbrains.erpsystem.repositories;


import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.geekbrains.erpsystem.entities.User;

@Repository
public interface UserRepository extends JpaRepository<User,Long> {
}
