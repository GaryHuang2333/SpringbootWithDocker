package com.gary.library.mongodatabase.conf;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import com.gary.library.yamlpropertysource.YamlPropertySourceFactory;

@Configuration
@PropertySource(value = "classpath:application-mongodb.yml", factory = YamlPropertySourceFactory.class)
public class MongoDatabaseAutoConfiguraion {
}
