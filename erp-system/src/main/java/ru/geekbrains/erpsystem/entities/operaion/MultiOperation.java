package ru.geekbrains.erpsystem.entities.operaion;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;


@Entity
@Getter
@Setter
@Table(name = "multi_operation_tbl")
public class MultiOperation extends AbstractOperation implements Operation{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "multi_operation_id")
    private Long id;

    @ManyToMany
    @JoinTable(
            name = "simple_op_multi_op_tbl",
            joinColumns = @JoinColumn(name = "multi_op_id"),
            inverseJoinColumns = @JoinColumn(name = "simple_op_id")
    )
    private List<SimpleOperation> simpleOperations = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "multi_op_sub_multi_op_tbl",
            joinColumns = @JoinColumn(name = "multi_op_id"),
            inverseJoinColumns = @JoinColumn(name = "sub_multi_op_id")
    )
    private List<MultiOperation> subMultiOperations = new ArrayList<>();

}
