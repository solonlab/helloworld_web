package com.example.demo.controller.demo

import com.example.demo.model.UserModel
import org.noear.solon.annotation.Body
import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Mapping
import org.noear.solon.core.handle.Context
import org.noear.solon.core.handle.ModelAndView
import org.noear.solon.core.handle.UploadedFile
import java.util.*


/**
 * 了解有哪些参数形式可以注入
 */
@Mapping("param")
@Controller
class ParamController {
    //非请求参数的可注入对象
    @Mapping("case1")
    fun case1(ctx: Context?, locale: Locale?, mv: ModelAndView?) {
    }

    //请求参数（可以是散装的；支持 queryString, form；json，或支持的其它序列化格式）
    @Mapping("case2")
    fun case2(userName: String?, nickName: String?) {
    }

    //请求参数（可以是整装的结构体；支持 queryString, form；json，或支持的其它序列化格式Mapping
    @Mapping("case3")
    fun case3(@Body user: UserModel?) {
    }

    //也可以是混搭的
    @Mapping("case4")
    fun case4(ctx: Context?, @Body user: UserModel?, userName: String?) {
    }

    //文件上传
    @Mapping("case5")
    fun case5(file: UploadedFile?) { //注意与 <input type='file' name="file" /> 名字对上
    }
}
