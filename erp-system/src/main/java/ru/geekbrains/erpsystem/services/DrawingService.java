package ru.geekbrains.erpsystem.services;

import ru.geekbrains.erpsystem.data.DrawingData;
import ru.geekbrains.erpsystem.entities.Drawing;

public interface DrawingService extends CrudService<Drawing, Long>{
    Drawing insert(DrawingData drawingData);
    Drawing update (DrawingData drawingData);
}
