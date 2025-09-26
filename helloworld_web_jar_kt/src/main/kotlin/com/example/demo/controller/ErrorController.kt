package com.example.demo.controller

import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Mapping
import org.noear.solon.annotation.Produces
import org.noear.solon.boot.web.MimeType


@Controller
class ErrorController {
    @Produces(MimeType.TEXT_HTML_VALUE)
    @Mapping("/error")
    fun error(): String {
        return "<html><body>出错了：（</body></html>"
    }
}

