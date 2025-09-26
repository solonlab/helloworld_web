package org.example.demo.controller.demo;

import org.example.demo.controller.BaseController;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.Result;
import org.noear.solon.validation.annotation.NotNull;

import java.util.LinkedHashMap;
import java.util.Map;

/**
 * 配合 index.htm 及过滤器的演示
 * */
@Mapping("demo")
@Controller
public class DemoController extends BaseController {
    @NotNull("name")
    @Mapping("template")
    public ModelAndView template(String name) {
        Map<String, Object> model = new LinkedHashMap<>();
        model.put("name", name);

        //输出动态视图
        return view("template.ftl", model);
    }

    @Mapping("error")
    public void error(){
        throw new RuntimeException("测试一下！");
    }


    @Mapping("ajax/json")
    public Object json(@NotNull String name) { //展示验证注解的不同风格
        return Result.succeed(name);
    }
}
