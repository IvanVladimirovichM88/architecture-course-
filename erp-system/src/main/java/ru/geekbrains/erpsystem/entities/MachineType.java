package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

@Entity
@Data
@Table(name = "machine_type_tbl")
public class MachineType implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "machine_type_id")
    Long id;

    @Column(name = "type_fld")
    String type;

    @ManyToMany
    @JoinTable(
            name = "machine_type_machine_tbl",
            joinColumns = @JoinColumn(name = "machine_type_id"),
            inverseJoinColumns = @JoinColumn(name = "machine_id"))
    List<Machine> machines = new ArrayList<>();


    public MachineType update(MachineType machineType){

        this.setType(machineType.getType());
        this.setMachines(machineType.getMachines());

        return this;
    }

}
