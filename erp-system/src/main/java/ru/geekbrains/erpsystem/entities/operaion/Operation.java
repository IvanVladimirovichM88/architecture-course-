package ru.geekbrains.erpsystem.entities.operaion;

import ru.geekbrains.erpsystem.entities.Drawing;

public interface Operation {

    Drawing getStartDetailDraw();
    Drawing getFinalDetailDraw();
    Integer getTime();

}
