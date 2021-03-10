package ru.geekbrains.erpsystem.entities.part;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Drawing;

import javax.persistence.*;

@Entity
@Getter
@Setter
@Table(name = "simple_part_id")
public class SimplePart extends AbstractPart implements Part{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "simple_part_id")
    private Long id;

    public SimplePart() {
    }

    public SimplePart(Drawing drawing) {
        super.setDrawing(drawing);
    }

    public SimplePart update(SimplePart simplePart){
        super.updateAbstract(simplePart);
        return this;
    }
}
