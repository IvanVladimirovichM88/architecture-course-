package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Billet;

import java.io.Serializable;

@Getter
@Setter
public class BilletData implements Serializable {
    private Long id;
    private String title;
    private String material;
    private String standard;

    public BilletData() {
    }

    public BilletData(Long id, String title, String material, String standard) {
        this.id = id;
        this.title = title;
        this.material = material;
        this.standard = standard;
    }

    public BilletData(Billet billet){
        this.id = billet.getId();
        this.title = billet.getTitle();
        this.material = billet.getMaterial();
        this.standard = billet.getStandard();
    }


}
