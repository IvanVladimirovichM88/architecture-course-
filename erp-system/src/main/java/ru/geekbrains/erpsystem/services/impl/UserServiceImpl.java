package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.data.UserData;
import ru.geekbrains.erpsystem.entities.Role;
import ru.geekbrains.erpsystem.entities.User;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.RoleRepository;
import ru.geekbrains.erpsystem.repositories.UserRepository;
import ru.geekbrains.erpsystem.services.UserService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class UserServiceImpl implements UserService {
    private UserRepository userRepository;
    private RoleRepository roleRepository;

    public UserServiceImpl(UserRepository userRepository,
                           RoleRepository roleRepository
    ) {
        this.userRepository = userRepository;
        this.roleRepository = roleRepository;
    }

    @Override
    public User insert(User user) {
        return userRepository.save(user);
    }

    @Override
    public User insert(UserData userData) {
        User insertUser = new User();

        insertUser.setName(userData.getName());
        insertUser.setUsername(userData.getUsername());
        insertUser.setPassword(userData.getPassword());

        List<Role> userRoles = userData.getRolesId().stream()
                .map( (roleId) -> roleRepository.findById(roleId).orElseThrow(()->new ResourceNotFoundException("INSERT", Role.class.getName())) )
                .collect(Collectors.toList());

        insertUser.setRoles(userRoles);

        return userRepository.save(insertUser);
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
