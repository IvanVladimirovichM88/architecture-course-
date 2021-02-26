package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "user_tbl")
public class User {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "user_id")
    Long id;

    @Column(name = "username_fld", unique = false)
    String username;

    @Column(name = "password_fld")
    String password;

    @Column(name = "name_fld")
    String name;

    @ManyToMany
    @JoinTable(
            name = "user_role_tbl",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id"))
    List<Role> roles = new ArrayList<>();

    @OneToMany(mappedBy = "developer")
    List<Drawing> drawings = new ArrayList<>();


    public User update (User user){
        this.setUsername(user.getUsername());
        this.setPassword(user.getPassword());
        this.setName(user.getName());
        this.setRoles(user.getRoles());

        return this;
    }


}
