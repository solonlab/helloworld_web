package org.example.demo.config;

import org.noear.snack.core.Feature;
import org.noear.solon.annotation.Bean;
import org.noear.solon.annotation.Configuration;
import org.noear.solon.serialization.snack3.SnackStringSerializer;

import java.math.BigDecimal;

@Configuration
public class JsonConfigure {
    @Bean
    public void init(SnackStringSerializer serializer){
        serializer.getSerializeConfig().addFeatures(Feature.EnumUsingName);

        serializer.addEncoder(Long.class, val -> String.valueOf(val));
        serializer.addEncoder(BigDecimal.class, val -> val.toPlainString());
    }
}
