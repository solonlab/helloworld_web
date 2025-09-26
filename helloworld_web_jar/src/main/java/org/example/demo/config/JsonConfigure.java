package org.example.demo.config;

import org.noear.snack.core.Feature;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.annotation.Inject;
import org.noear.solon.serialization.snack3.SnackRenderFactory;

import java.math.BigDecimal;

@Configuration
public class JsonConfigure {
    @Bean
    public void init(@Inject SnackRenderFactory factory){
        factory.config().add(Feature.EnumUsingName);

        factory.addConvertor(Long.class, val -> String.valueOf(val));
        factory.addConvertor(BigDecimal.class, val -> val.toPlainString());
    }
}
