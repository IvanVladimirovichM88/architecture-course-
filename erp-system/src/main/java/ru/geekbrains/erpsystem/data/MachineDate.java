package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Machine;
import ru.geekbrains.erpsystem.entities.MachineType;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;
import java.util.stream.Collectors;


@Getter
@Setter
public class MachineDate implements Serializable {
    private Long id;
    private String title;
    private Set<Long> machineTypesId = new HashSet<>();

    public MachineDate() {
    }

    public MachineDate(Long id, String title, Set<Long> machineTypesId) {
        this.id = id;
        this.title = title;
        this.machineTypesId = machineTypesId;
    }

    public MachineDate(Machine machine){
        this.id = machine.getId();
        this.title = machine.getTitle();
        this.machineTypesId = machine.getTypes().stream()
                .map(MachineType::getId)
                .collect(Collectors.toSet());
    }
}
