package ru.geekbrains.erpsystem.data;

import lombok.Getter;
import lombok.Setter;
import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.part.SimplePart;

import java.io.Serializable;

@Getter
@Setter
public class SimplePartData implements Serializable {

    private Long id;

    private Long drawingId;

    private String drawingTitleWithNumber;

    public SimplePartData() {
    }

    public SimplePartData(SimplePart simplePart){

        DrawingData drawingData = new DrawingData(simplePart.getDrawing());

        this.id = simplePart.getId();
        this.drawingId = drawingData.getId();
        this.drawingTitleWithNumber = drawingData.getNumber() + drawingData.getTitle();

    }
}
