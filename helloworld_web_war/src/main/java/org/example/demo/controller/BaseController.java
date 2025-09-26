package org.example.demo.controller;

import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.validation.annotation.Valid;

import java.util.Map;

/**
 * 控制器基类（加了验证注解支持）
 * */
@Valid
public class BaseController {
    public ModelAndView view(String view, Map<String, Object> model) {
        ModelAndView mv = new ModelAndView(view, model);

        //添加公共变量
        mv.put("_title", "标题");
        mv.put("_author", "noear");

        return mv;
    }
}
