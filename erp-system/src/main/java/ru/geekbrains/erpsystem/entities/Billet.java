package ru.geekbrains.erpsystem.entities;


import lombok.Data;

import javax.persistence.*;

@Entity
@Data
@Table(name = "billet_tbl")
public class Billet { // заготовка для детали
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "billet_id")
    Long id;

    @Column(name = "title_fld")
    String title;

    @Column(name = "material_fld")
    String material;

    @Column(name = "weight_fld")
    Double weight;

    public Billet update(Billet billet){
        this.setTitle(billet.title);
        this.setMaterial(billet.getMaterial());
        this.setWeight(billet.getWeight());
        return this;
    }

}
