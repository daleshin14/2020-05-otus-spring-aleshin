package ru.daleshin.spring;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.context.properties.EnableConfigurationProperties;

import ru.daleshin.spring.config.YamlProps;

@SpringBootApplication
@EnableConfigurationProperties(YamlProps.class)
public class SpringDa03Application {

	public static void main(String[] args) {
		SpringApplication.run(SpringDa03Application.class, args);
	}

}
