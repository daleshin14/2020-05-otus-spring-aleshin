package ru.daleshin.spring;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

import org.springframework.context.support.ClassPathXmlApplicationContext;

import ru.daleshin.spring.service.QuestionService;
import ru.daleshin.spring.domain.Question;
import ru.daleshin.spring.service.PropertyService;

public class Main {

    public static void main(String[] args) {
    	
    	ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("/spring-context.xml");

    	// читаем настройку с именем файла
    	PropertyService propertyService = context.getBean(PropertyService.class);
    	//System.out.println("questionsFileName="+propertyService.getQuestionsFileName());
    	
        if(propertyService.getQuestionsFileName()!=null) {
        	// читаем список вопросов из файла
        	List<Question> questionList = getQuestionList(propertyService.getQuestionsFileName());
        	for(Question question : questionList) {
        		System.out.println(question.getText());
        		if(question.getAnswers().size()>0) {
        			System.out.print("Select your answer:");
        			for(String answer : question.getAnswers()) {
        				System.out.print("\t"+answer);
        			}
        			System.out.println("");
        		}else {
        			System.out.println("Input your answer:\t");
        		}
        	}
        }else {
        	System.out.println("questionsFileName is null.");
        }
        
        context.close();
    }
    
    private static List<Question> getQuestionList(String fileName){
    	List<Question> res = new ArrayList<>();
    	Scanner scanner = new Scanner(Main.class.getResourceAsStream(fileName));
        scanner.useDelimiter(";");
        while(scanner.hasNextLine()){
        	String questionText = null;
        	String rightAnswer = null;
        	List<String> answerList = new ArrayList<>();
        	Scanner scannerLine = new Scanner(scanner.nextLine());
            scannerLine.useDelimiter(";");
            while(scannerLine.hasNext()){
                if(questionText==null) {
                	questionText=scannerLine.next();
                }else
                if(rightAnswer==null) {
                	rightAnswer=scannerLine.next();
                }else {
                	answerList.add(scannerLine.next());
                }
            }
            res.add(new Question(questionText, rightAnswer, answerList));
            //System.out.println("questionText="+questionText+" rightAnswer="+rightAnswer+" answerList="+answerList);
            scannerLine.close();
        }
        scanner.close();
        
        return res;
    }
    

    
}

