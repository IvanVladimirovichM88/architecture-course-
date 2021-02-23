package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "role_tbl")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "role_id")
    Long id;

    @Column(name = "title_fld", unique = true)
    String title;
}
