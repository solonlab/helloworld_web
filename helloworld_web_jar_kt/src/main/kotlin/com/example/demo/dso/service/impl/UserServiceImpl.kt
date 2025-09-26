package com.example.demo.dso.service.impl

import com.example.demo.dso.service.UserService
import com.example.demo.model.UserModel
import org.noear.solon.annotation.Component
import org.noear.solon.data.annotation.Tran


@Component
open class UserServiceImpl : UserService {
    override fun getUser(userId: Int): UserModel? {
        val user = UserModel()
        user.userId = userId;
        user.userName = "user-$userId";
        return user
    }

    @Tran
    override fun addUser(user: UserModel?) {}
}

