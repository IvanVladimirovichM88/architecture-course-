package ru.geekbrains.erpsystem.entities.operaion;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.User;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MappedSuperclass;

@MappedSuperclass
@Getter
@Setter
public class AbstractOperation {
    @ManyToOne
    @JoinColumn(name = "start_detail_draw_id")
    private Drawing startDetailDraw;

    @ManyToOne
    @JoinColumn(name = "final_detail_draw_id")
    private Drawing finalDetailDraw;

    @Column(name = "time_fld")
    private Integer time;

    @ManyToOne
    @JoinColumn(name = "developer_user_id")
    private User developer;

}
