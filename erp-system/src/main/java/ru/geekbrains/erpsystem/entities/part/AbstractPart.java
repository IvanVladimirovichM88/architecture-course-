package ru.geekbrains.erpsystem.entities.part;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.User;
import ru.geekbrains.erpsystem.entities.operaion.MultiOperation;

import javax.persistence.*;

@MappedSuperclass
@Getter
@Setter
public class AbstractPart {

    @OneToOne
    @JoinColumn(name = "draw_id")
    private Drawing drawing;

    public AbstractPart updateAbstract(AbstractPart part){
        this.setDrawing(part.getDrawing());
        return this;
    }

}
