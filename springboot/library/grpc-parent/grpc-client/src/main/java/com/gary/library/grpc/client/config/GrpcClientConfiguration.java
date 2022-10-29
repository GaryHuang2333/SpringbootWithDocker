package com.gary.library.grpc.client.config;

import com.gary.library.yamlpropertysource.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-grpcclient.yml", factory = YamlPropertySourceFactory.class)
public class GrpcClientConfiguration {
}
