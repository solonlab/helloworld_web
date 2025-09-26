package org.example.demo.controller.user;

import org.example.demo.controller.BaseController;
import org.example.demo.dso.service.UserService;
import org.example.demo.model.UserModel;
import org.noear.solon.annotation.Controller;
import org.noear.solon.annotation.Inject;
import org.noear.solon.annotation.Mapping;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * @author noear
 * @since demo 1.0
 */
@Mapping("user")
@Controller
public class UserController extends BaseController {
    static final Logger log = LoggerFactory.getLogger(UserController.class);

    @Inject
    UserService userService;

    @Mapping("test")
    public String test() {
        log.info("test page");
        UserModel user = userService.getUser(1);
        return "Hello " + user.getUserName();
    }
}
