package com.example.demo.config

import org.noear.snack.core.Feature
import org.noear.solon.annotation.Bean
import org.noear.solon.annotation.Configuration
import org.noear.solon.annotation.Inject
import org.noear.solon.serialization.snack3.SnackRenderFactory
import java.math.BigDecimal


@Configuration
class JsonConfigure {
    @Bean
    fun init(@Inject factory: SnackRenderFactory) {
        factory.config().add(Feature.EnumUsingName)
        factory.addConvertor(Long::class.java) { `val`: Long -> `val`.toString() }
        factory.addConvertor(BigDecimal::class.java) { `val`: BigDecimal -> `val`.toPlainString() }
    }
}