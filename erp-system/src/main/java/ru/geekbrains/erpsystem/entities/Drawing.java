package ru.geekbrains.erpsystem.entities;

import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "drawing_tbl")
public class Drawing {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "drawing_id")
    Long id;

    @Column(name = "number_fld", unique = true)
    String number;

    @Column(name = "title_fld")
    String title;

    @ManyToOne
    @JoinColumn(name = "user_id")
    User developer;

    @ManyToOne
    @JoinColumn(name = "billet_id")
    Billet billet;

    public Drawing update(Drawing drawing){
        this.setNumber(drawing.getNumber());
        this.setTitle(drawing.getTitle());
        this.setDeveloper(drawing.getDeveloper());
        this.setBillet(drawing.getBillet());
        return this;
    }


}
