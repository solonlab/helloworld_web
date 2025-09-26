package com.example.demo.controller.demo

import com.example.demo.controller.BaseController
import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Mapping
import org.noear.solon.core.handle.ModelAndView
import org.noear.solon.core.handle.Result
import org.noear.solon.validation.annotation.NotNull

/**
 * 配合 index.htm 及过滤器的演示
 */
@Mapping("demo")
@Controller
class DemoController : BaseController() {
    @NotNull("name")
    @Mapping("template")
    fun template(name: String): ModelAndView {
        val model: MutableMap<String, Any> = LinkedHashMap()
        model["name"] = name

        //输出动态视图
        return view("template.ftl", model)
    }

    @Mapping("error")
    fun error() {
        throw RuntimeException("测试一下！")
    }

    @Mapping("ajax/json")
    fun json(@NotNull name: String): Any { //展示验证注解的不同风格
        return Result.succeed(name)
    }
}

