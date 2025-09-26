package org.example.demo;

import org.noear.solon.Solon;
import org.noear.solon.annotation.SolonMain;

/**
 * @author noear
 * @since demo 1.0
 */
@SolonMain
public class DemoApp {
    public static void main(String[] args) {
        Solon.start(DemoApp.class, args);
    }
}
