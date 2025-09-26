package features;

import org.example.demo.DemoApp;

import org.junit.jupiter.api.Test;

import org.noear.solon.test.HttpTester;
import org.noear.solon.test.SolonTest;

/**
 * @author noear
 * @since demo 1.0
 */
@SolonTest(DemoApp.class)
public class HelloTest extends HttpTester {
    @Test
    public void test() throws Exception {
        assert path("/user/test").get().contains("Hello");
    }
}
