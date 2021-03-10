package ru.geekbrains.erpsystem.services;

import ru.geekbrains.erpsystem.data.MultiPartData;
import ru.geekbrains.erpsystem.entities.part.MultiPart;

public interface MultiPartService extends CrudService<MultiPart, Long>{
    MultiPart insert (MultiPartData multiPartData);
}
