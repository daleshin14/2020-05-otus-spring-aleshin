package ru.daleshin.spring;

import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.PropertySource;

import ru.daleshin.spring.config.ServicesConfig;
import ru.daleshin.spring.config.YamlProps;

@Configuration
@Import(ServicesConfig.class)
@PropertySource(value = "classpath:application.yml")
@EnableConfigurationProperties(YamlProps.class)
public class TestServicesConfig {

}
