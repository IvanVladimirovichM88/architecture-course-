package ru.geekbrains.erpsystem.entities.part;

import ru.geekbrains.erpsystem.entities.Drawing;
import ru.geekbrains.erpsystem.entities.User;
import ru.geekbrains.erpsystem.entities.operaion.MultiOperation;

import java.util.List;

public interface Part {
    Integer getTime();
    Drawing getDrawing();
    User getDeveloper();
    MultiOperation getTechnology();
}
