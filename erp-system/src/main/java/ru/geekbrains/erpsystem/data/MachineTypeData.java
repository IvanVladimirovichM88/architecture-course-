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
public class MachineTypeData implements Serializable {
    private Long id;
    private String type;
    private Set<Long> machinesId = new HashSet<>();

    public MachineTypeData() {
    }

    public MachineTypeData(Long id, String type, Set<Long> machinesId) {
        this.id = id;
        this.type = type;
        this.machinesId = machinesId;
    }

    public MachineTypeData(MachineType machineType){
        this.id = machineType.getId();
        this.type = machineType.getType();
        this.machinesId = machineType.getMachines().stream()
                .map(Machine::getId)
                .collect(Collectors.toSet());
    }
}
