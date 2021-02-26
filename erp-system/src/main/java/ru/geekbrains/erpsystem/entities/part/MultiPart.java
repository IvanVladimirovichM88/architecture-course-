package ru.geekbrains.erpsystem.entities.part;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
@Getter
@Setter
@Table(name = "multi_part_tbl")
public class MultiPart extends AbstractPart implements Part {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column( name = "multi_part_id")
    Long id;

    @ManyToMany
    @JoinTable(
            name = "simple_part_multi_part_tbl",
            joinColumns = @JoinColumn(name = "multi_part_id"),
            inverseJoinColumns = @JoinColumn(name = "simple_part")
    )
    private List<SimplePart> simpleParts = new ArrayList<>();

    @ManyToMany
    @JoinTable(
            name = "multi_part_sub_multi_part_tbl",
            joinColumns = @JoinColumn(name = "multi_part"),
            inverseJoinColumns = @JoinColumn(name = "sub_multi_part")
    )
    List<MultiPart> subMultiPart = new ArrayList<>();

    public MultiPart update(MultiPart multiPart){

        super.updateAbstract(multiPart);

        this.setSimpleParts(multiPart.getSimpleParts());
        this.setSubMultiPart(multiPart.getSubMultiPart());

        return this;
    }

}
