package org.example.demo.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;

@Controller
public class HomeController {
    @Mapping("/")
    public void home(Context ctx) {
        //内部跳转到 /index.htm
        ctx.forward("/index.htm");
    }
}
