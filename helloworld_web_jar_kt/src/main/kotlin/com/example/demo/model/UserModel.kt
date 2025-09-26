package com.example.demo.model

import java.io.Serializable

/**
 * 配合参数注入的模型
 */
class UserModel : Serializable {
    var userId: Int? = 0
    var userName: String? = null
}

