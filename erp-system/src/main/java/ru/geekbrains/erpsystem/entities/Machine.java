package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.util.List;

@Entity
@Data
@Table(name = "machine_tbl")
public class Machine {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_id")
    Long id;

    @Column(name = "title_fld")
    String title;

    @ManyToMany
    @JoinTable(
            name = "machine_type_machine_tbl",
            joinColumns = @JoinColumn(name = "machine_id"),
            inverseJoinColumns = @JoinColumn(name = "machine_type_id"))
    List<MachineType> types;

}
