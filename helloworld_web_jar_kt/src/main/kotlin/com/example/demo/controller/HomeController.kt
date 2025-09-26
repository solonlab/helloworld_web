package com.example.demo.controller

import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Mapping
import org.noear.solon.core.handle.Context


@Controller
class HomeController {
    @Mapping("/")
    fun home(ctx: Context) {
        //内部跳转到 /index.htm
        ctx.forward("/index.htm")
    }
}

