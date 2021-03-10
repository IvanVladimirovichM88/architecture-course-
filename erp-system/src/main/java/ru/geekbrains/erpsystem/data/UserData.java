package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.Role;
import ru.geekbrains.erpsystem.entities.User;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;

@Getter
@Setter
public class UserData implements Serializable {
    private Long id;
    private String username;
    private String password;
    private String name;
    private Set<Long> rolesId = new HashSet<>();
    private Set<Long> drawingsId = new HashSet<>();

    public UserData() {
    }

    public UserData(Long id, String username, String password, String name, Set<Long> rolesId, Set<Long> drawingsId) {
        this.id = id;
        this.username = username;
        this.password = password;
        this.name = name;
        this.rolesId = rolesId;
        this.drawingsId = drawingsId;
    }

    public UserData(User user) {
        this.id = user.getId();
        this.username = user.getUsername();
        this.password = user.getPassword();
        this.name = user.getName();
        this.rolesId = user.getRoles().stream()
                .map(Role::getId).collect(Collectors.toSet());
        this.drawingsId = user.getDrawings().stream()
                .map(Drawing::getId).collect(Collectors.toSet());
    }
}
