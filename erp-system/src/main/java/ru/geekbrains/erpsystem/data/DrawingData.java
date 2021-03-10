package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Drawing;

@Getter
@Setter
public class DrawingData {
    private Long id;
    private String number;
    private String title;
    private Long developerUserId;
    private Long billetId;

    public DrawingData() {
    }

    public DrawingData(Long id, String number, String title, Long developerUserId, Long billetId) {
        this.id = id;
        this.number = number;
        this.title = title;
        this.developerUserId = developerUserId;
        this.billetId = billetId;
    }

    public DrawingData(Drawing drawing){
        this.id = drawing.getId();
        this.number = drawing.getNumber();
        this.title = drawing.getTitle();
        this.developerUserId = drawing.getDeveloper().getId();
        this.billetId = drawing.getBillet().getId();
    }


}
