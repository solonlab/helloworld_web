package com.example.demo.dso.service

import com.example.demo.model.UserModel

interface UserService {
    fun getUser(userId: Int): UserModel?

    fun addUser(user: UserModel?)
}