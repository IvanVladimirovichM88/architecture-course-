package ru.geekbrains.erpsystem.entities.operaion;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Machine;
import ru.geekbrains.erpsystem.entities.User;

import javax.persistence.*;


@Entity
@Getter
@Setter
@Table(name = "simple_operation_tbl")
public class SimpleOperation extends AbstractOperation implements Operation {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simple_operation_id")
    private Long id;

    @Column(name = "description_fld")
    private String description;

    @ManyToOne
    @JoinColumn(name = "operator_user_id")
    private User operatorMachine;


    @ManyToOne
    @JoinColumn(name = "machine_id")
    private Machine machine;

}
