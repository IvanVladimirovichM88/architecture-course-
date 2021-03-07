package ru.geekbrains.erpsystem.services;

import ru.geekbrains.erpsystem.data.SimplePartData;
import ru.geekbrains.erpsystem.entities.part.SimplePart;

public interface SimplePartService extends CrudService<SimplePart,Long> {
    SimplePart insert(SimplePartData simplePartData);
}
