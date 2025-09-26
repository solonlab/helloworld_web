package org.example.demo.dso.service;

import org.example.demo.model.UserModel;

public interface UserService {
    UserModel getUser(int userId);

    void addUser(UserModel user);
}
