package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.User;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.UserRepository;
import ru.geekbrains.erpsystem.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;

    public UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public User update(User user) {
        User updateUser = getById(user.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE",User.class.getName()));
        updateUser.update(user);

        return userRepository.save(updateUser);
    }

    @Override
    public void delete(Long userId) {
        User deleteUser = getById(userId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE", User.class.getName()));
        userRepository.delete(deleteUser);
    }

    @Override
    public Optional<User> getById(Long userId) {
        return userRepository.findById(userId);
    }

    @Override
    public List<User> getAll() {
        return Collections.unmodifiableList(userRepository.findAll());
    }
}
