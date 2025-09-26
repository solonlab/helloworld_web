package org.example.demo.controller;

import org.noear.solon.validation.annotation.Logined;

/**
 * 已登录控制器基类（加了登录验证注解支持；这个注解需要适配，参考：https://solon.noear.org/article/225）
 * */

@Logined
public class BaseLoginedController extends  BaseController {
}
