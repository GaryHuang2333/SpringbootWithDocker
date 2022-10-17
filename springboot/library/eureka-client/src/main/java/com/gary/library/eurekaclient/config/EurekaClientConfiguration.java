package com.gary.library.eurekaclient.config;


import com.gary.library.yamlpropertysource.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application-eurekaclient.yml", factory = YamlPropertySourceFactory.class)
public class EurekaClientConfiguration {
}
