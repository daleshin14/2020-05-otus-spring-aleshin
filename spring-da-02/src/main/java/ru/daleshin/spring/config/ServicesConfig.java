package ru.daleshin.spring.config;

import java.io.PrintStream;
import java.util.Scanner;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

import ru.daleshin.spring.Main;
import ru.daleshin.spring.dao.QuestionDao;
import ru.daleshin.spring.dao.QuestionDaoImpl;
import ru.daleshin.spring.service.InputOutputService;
import ru.daleshin.spring.service.InputOutputServiceImpl;
import ru.daleshin.spring.service.QuestionService;
import ru.daleshin.spring.service.QuestionServiceImpl;

@Configuration
@PropertySource(value = "classpath:application.yml")
@ConfigurationProperties(prefix = "question")
public class ServicesConfig {
    
    @Bean
    public QuestionService questionService(QuestionDao dao, InputOutputService ioService,
    		@Value("${numberOfCorrectAnswers}") String numberOfCorrectAnswers) {
        return new QuestionServiceImpl(dao, ioService, numberOfCorrectAnswers);
    }
    
    @Bean
    public QuestionDao questionDao(InputOutputService ioService) {
        return new QuestionDaoImpl(ioService);
    }

    @Bean
    InputOutputService inputOutputService(@Value("${filename}") String filename) {
        return new InputOutputServiceImpl(new Scanner(Main.class.getResourceAsStream(filename)).useDelimiter(";"), 
        		new PrintStream(System.out), new Scanner(System.in));
    }
}
