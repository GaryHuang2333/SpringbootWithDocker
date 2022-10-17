package com.gary.library.yamlpropertysource;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.config.YamlPropertiesFactoryBean;
import org.springframework.core.env.PropertiesPropertySource;
import org.springframework.core.env.PropertySource;
import org.springframework.core.io.support.EncodedResource;
import org.springframework.core.io.support.PropertySourceFactory;

import java.io.IOException;
import java.util.Properties;

public class YamlPropertySourceFactory implements PropertySourceFactory {
    private final Logger logger = LoggerFactory.getLogger(this.getClass());

    @Override
    public PropertySource createPropertySource(String name, EncodedResource encodedResource) {
        logger.info("properties files : {}", encodedResource.getResource().getFilename());
        // 创建YAML解析工厂
        YamlPropertiesFactoryBean factory = new YamlPropertiesFactoryBean();
        // 设置资源
        factory.setResources(encodedResource.getResource());
        // 获取解析后的Properties对象
        Properties properties = factory.getObject();
        //返回对象.
        PropertiesPropertySource propertySource;
        if(name != null){
            propertySource = new PropertiesPropertySource(name, properties);
        }else {
            propertySource = new PropertiesPropertySource(encodedResource.getResource().getFilename(), properties);
        }

        return propertySource;
    }
}
