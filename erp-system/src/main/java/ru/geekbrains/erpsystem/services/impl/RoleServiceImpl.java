package ru.geekbrains.erpsystem.services.impl;

import org.springframework.stereotype.Service;
import ru.geekbrains.erpsystem.entities.Role;
import ru.geekbrains.erpsystem.exceptions.ResourceNotFoundException;
import ru.geekbrains.erpsystem.repositories.RoleRepository;
import ru.geekbrains.erpsystem.services.RoleService;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class RoleServiceImpl implements RoleService {
    RoleRepository roleRepository;

    public RoleServiceImpl(RoleRepository roleRepository) {
        this.roleRepository = roleRepository;
    }

    @Override
    public Role insert(Role role) {
        return roleRepository.save(role);
    }

    @Override
    public Role update(Role role) {
        Role updateRole = getById(role.getId())
                .orElseThrow(()->new ResourceNotFoundException("UPDATE",Role.class.getName()));
        updateRole.update(role);

        return roleRepository.save(updateRole);
    }

    @Override
    public void delete(Long roleId) {
        Role deleteRole = roleRepository.findById(roleId)
                .orElseThrow(()->new ResourceNotFoundException("DELETE", Role.class.getName()));
        roleRepository.delete(deleteRole);
    }

    @Override
    public Optional<Role> getById(Long roleId) {
        return roleRepository.findById(roleId);
    }

    @Override
    public List<Role> getAll() {
        return Collections.unmodifiableList(roleRepository.findAll());
    }
}
