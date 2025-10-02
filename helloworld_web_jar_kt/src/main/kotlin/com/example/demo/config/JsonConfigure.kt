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
    fun init(serializer: SnackStringSerializer) {
        serializer.getSerializeConfig().addFeatures(Feature.EnumUsingName)

        serializer.addEncoder(Long::class.java) { `val`: Long -> `val`.toString() }
        serializer.addEncoder(BigDecimal::class.java) { `val`: BigDecimal -> `val`.toPlainString() }
    }
}