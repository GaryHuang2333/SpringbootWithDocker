package com.gary.library.grpcserver.config;

import com.gary.library.yamlpropertysource.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-grpcserver.yml", factory = YamlPropertySourceFactory.class)
public class GrpcServerConfiguration {
}
