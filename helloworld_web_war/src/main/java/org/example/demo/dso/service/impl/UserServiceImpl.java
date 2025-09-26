package org.example.demo.dso.service.impl;

import org.noear.solon.annotation.Component;

import org.example.demo.dso.service.UserService;
import org.example.demo.model.UserModel;

@Component
public class UserServiceImpl implements UserService {
    @Override
    public UserModel getUser(int userId) {
        UserModel user = new UserModel();
        user.setUserId(userId);
        user.setUserName("user-" + user);

        return user;
    }

    @Override
    public void addUser(UserModel user) {

    }
}
