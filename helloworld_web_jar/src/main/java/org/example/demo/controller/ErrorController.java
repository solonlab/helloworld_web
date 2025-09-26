package org.example.demo.controller;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.annotation.Produces;
import org.noear.solon.boot.web.MimeType;

@Controller
public class ErrorController {
    @Produces(MimeType.TEXT_HTML_VALUE)
    @Mapping("/error")
    public String error(){
        return "<html><body>出错了：（</body></html>";
    }
}
