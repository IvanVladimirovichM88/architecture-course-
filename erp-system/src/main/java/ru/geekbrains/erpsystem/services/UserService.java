package ru.geekbrains.erpsystem.services;

import ru.geekbrains.erpsystem.data.UserData;
import ru.geekbrains.erpsystem.entities.User;

public interface UserService extends CrudService<User,Long>{
    User insert(UserData userData);
}
