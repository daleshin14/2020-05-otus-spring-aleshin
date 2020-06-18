package ru.daleshin.spring;

import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import ru.daleshin.spring.service.QuestionService;

@Configuration
@ComponentScan
public class Main {

    public static void main(String[] args) {
    	
    	AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(Main.class);

    	QuestionService service = context.getBean(QuestionService.class);
    	service.performTesting();
        
        context.close();
    }
    
}

