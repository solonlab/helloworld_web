package com.example.demo.controller.demo

import org.noear.solon.annotation.Controller
import org.noear.solon.annotation.Mapping


/**
 * 了解路径映射支持的表达式
 */
@Mapping("mapping")
@Controller
class MappingController {
    @Mapping("") //=/user
    fun home() {
    }

    @Mapping("/") //=/user/，与上面是有区别的，注意下。
    fun home2() {
    }

    @Mapping("list")
    fun getList() {

    }

    @Mapping("/{id}") //=/user/{id}
    fun getOne(id: Long) {
    }

    @Mapping("/ajax/**") //=/user/ajax/**
    fun ajax() {
    }
}

