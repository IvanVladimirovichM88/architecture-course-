package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Role;

import java.io.Serializable;

@Getter
@Setter
public class RoleData implements Serializable {
    private Long id;
    private String title;

    public RoleData() {
    }

    public RoleData(Long id, String title) {
        this.id = id;
        this.title = title;
    }

    public RoleData(Role role){
        this.id = role.getId();
        this.title = role.getTitle();
    }
}
