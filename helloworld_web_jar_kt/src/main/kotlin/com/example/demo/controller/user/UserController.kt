package com.example.demo.controller.user

import com.example.demo.controller.BaseController
import com.example.demo.dso.service.UserService
import com.example.demo.model.UserModel
import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Inject
import org.noear.solon.annotation.Mapping
import org.slf4j.Logger
import org.slf4j.LoggerFactory

/**
 * @author noear
 * @since demo 1.0
 */
@Mapping("user")
@Controller
class UserController : BaseController() {
    val log: Logger = LoggerFactory.getLogger(UserController::class.java)

    @Inject
    var userService: UserService? = null

    @Mapping("test")
    fun test(): String {
        log.info("test page")
        val user: UserModel? = userService?.getUser(1)
        return "Hello " + user?.userName;
    }
}

