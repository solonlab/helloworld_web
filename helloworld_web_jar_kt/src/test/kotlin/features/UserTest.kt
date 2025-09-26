package features

import com.example.demo.App

import org.junit.jupiter.api.Test

import org.noear.solon.test.HttpTester
import org.noear.solon.test.SolonTest

@SolonTest(App::class)
open class UserTest : HttpTester() {
    @Test
    fun hello() {
        assert(path("/user/test").get().contains("Hello"))
    }
}