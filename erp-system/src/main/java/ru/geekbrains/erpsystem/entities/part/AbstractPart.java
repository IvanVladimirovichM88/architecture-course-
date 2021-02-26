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

    @ManyToOne
    @JoinColumn(name = "developer_user_id")
    private User developer;

    @Column(name = "time_fld")
    private Integer time;

    @OneToOne
    @JoinColumn(name = "technology_id")
    MultiOperation technology;

    public AbstractPart updateAbstract(AbstractPart part){
        this.setDrawing(part.getDrawing());
        this.setDeveloper(part.getDeveloper());
        this.setTime(part.getTime());
        this.setTechnology(part.getTechnology());

        return this;
    }

}
