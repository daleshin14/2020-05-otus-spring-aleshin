package ru.daleshin.spring.config;

import java.io.PrintStream;
import java.util.Locale;
import java.util.Scanner;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import ru.daleshin.spring.SpringDa03Application;
import ru.daleshin.spring.service.InputOutputService;
import ru.daleshin.spring.service.InputOutputServiceImpl;

@Configuration
@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "question")
public class ServicesConfig {

    @Bean
    InputOutputService inputOutputService(YamlProps yamlProps) {
        return new InputOutputServiceImpl(
        		new Scanner(SpringDa03Application.class.getResourceAsStream(new Locale("ru").equals(yamlProps.getLocale())?yamlProps.getFilenameRu():yamlProps.getFilenameEn())).useDelimiter(";"), 
        		new PrintStream(System.out), new Scanner(System.in));
    }
    
    @Bean
    public MessageSource messageSource() {
        var ms = new ReloadableResourceBundleMessageSource();
        ms.setBasename("classpath:/i18n/messages");
        ms.setDefaultEncoding("UTF-8");
        return ms;
    }
}
