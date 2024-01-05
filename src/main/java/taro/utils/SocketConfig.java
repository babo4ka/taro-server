package taro.utils;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@Data
@PropertySource("application.properties")
public class SocketConfig {

    @Value("${taro-host}")
    private String host;

    @Value("${taro-port}")
    private int port;
}
