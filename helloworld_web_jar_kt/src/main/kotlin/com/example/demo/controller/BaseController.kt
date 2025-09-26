package com.example.demo.controller

import org.noear.solon.core.handle.ModelAndView
import org.noear.solon.validation.annotation.Valid

/**
 * 控制器基类（加了验证注解支持）
 */
@Valid
open class BaseController {
    fun view(view: String?, model: MutableMap<String, Any>): ModelAndView {
        val mv = ModelAndView(view, model)

        //添加公共变量
        mv.put("_title", "标题")
        mv.put("_author", "noear")
        return mv
    }
}
