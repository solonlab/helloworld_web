package org.example.demo.controller.demo;

import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Mapping;

/**
 * 了解路径映射支持的表达式
 * */
@Mapping("mapping")
@Controller
public class MappingController {
    @Mapping("") //=/user
    public void home(){

    }

    @Mapping("/") //=/user/，与上面是有区别的，注意下。
    public void home2(){

    }

    @Mapping("list") //=/user/list ，间隔自动会补"/"
    public void getList(){

    }

    @Mapping("/{id}") //=/user/{id}
    public void getOne(long id){

    }

    @Mapping("/ajax/**") //=/user/ajax/**
    public void ajax(){

    }
}
