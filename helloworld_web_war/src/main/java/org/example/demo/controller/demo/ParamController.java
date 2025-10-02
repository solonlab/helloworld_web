package org.example.demo.controller.demo;

import org.example.demo.model.UserModel;
import org.noear.solon.annotation.Body;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;
import org.noear.solon.core.handle.Context;
import org.noear.solon.core.handle.ModelAndView;
import org.noear.solon.core.handle.UploadedFile;

import java.util.Locale;

/**
 * 了解有哪些参数形式可以注入
 * */
@Mapping("param")
@Controller
public class ParamController {
    //非请求参数的可注入对象
    @Mapping("case1")
    public void case1(Context ctx, Locale locale , ModelAndView mv){
    }

    //请求参数（可以是散装的；支持 queryString, form；json，或支持的其它序列化格式）
    @Mapping("case2")
    public void case2(String userName, String nickName){
    }

    //请求参数（可以是整装的结构体；支持 queryString, form；json，或支持的其它序列化格式Mapping
    @Mapping("case3")
    public void case3(@Body UserModel user){
    }

    //也可以是混搭的（混搭时，不利于 swagger 生成）
    @Mapping("case4")
    public void case4(Context ctx, @Body UserModel user, String userName){
    }

    //文件上传
    @Mapping("case5")
    public void case5(UploadedFile file){ //注意与 <input type='file' name="file" /> 名字对上
    }
}
