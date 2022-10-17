package com.gary.service.documentsservice.config;

import com.gary.library.yamlpropertysource.YamlPropertySourceFactory;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Configuration
@PropertySource(value = "classpath:application.yml", factory = YamlPropertySourceFactory.class)
public class DocumentsServiceConfiguration {
}
