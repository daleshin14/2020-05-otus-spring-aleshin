package ru.daleshin.spring.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.MessageSource;
import org.springframework.stereotype.Service;

import lombok.NoArgsConstructor;
import lombok.RequiredArgsConstructor;
import ru.daleshin.spring.config.YamlProps;
import ru.daleshin.spring.dao.QuestionDao;
import ru.daleshin.spring.domain.Question;

@Service
@RequiredArgsConstructor
public class QuestionServiceImpl implements QuestionService, CommandLineRunner {

    private final QuestionDao dao;
	private final InputOutputService ioService;
    private final YamlProps yamlProps;
    private final MessageSource messageSource;
    
    @Override
    public List<Question> getListOfQuestions(){

    	return dao.getQuestionList();
    }
    
    @Override
    public void run(String... args) {
    	int numberOfEnteredCorrectAnswers = 0;
    	try {
    		String userName = getEnteredName();
    		
        	int questionCount = 1;
        	for(Question question : dao.getQuestionList()) {
        		ioService.println(messageSource.getMessage("text.of.question", new String[]{String.valueOf(questionCount), question.getText()}, yamlProps.getLocale()));
        		
        		if(!question.getAnswers().isEmpty()) {
        			ioService.println(getAnswersString(question));
        			String inputedAnswer = getEnteredAnswer();
        			if(question.getRightAnswerNumber().equals(inputedAnswer)) {
        				numberOfEnteredCorrectAnswers++;
        			}
        		} else {
        			ioService.println(messageSource.getMessage("input.answer.text", new String[]{}, yamlProps.getLocale()));
        		}
        		questionCount++;
        	}
        	validateResult(numberOfEnteredCorrectAnswers, userName);
    	}catch(Exception e) {
    		ioService.println("Error. "+e);
    	}
    	
    }
    
    private String getAnswersString(Question question) {
    	StringBuilder res = new StringBuilder();
    	int answerCount = 1;
		for(String answer : question.getAnswers()) {
			if("".contentEquals(answer)) {
				continue;
			}
			res.append("\t").append(answerCount).append(").").append(answer);
			answerCount++;
		}
		return res.toString();
    }
    
    private String getEnteredName() {
    	// Enter your last and first name
    	ioService.print(messageSource.getMessage("input.name", new String[]{}, yamlProps.getLocale()));
    	String inputedName = ioService.nextLineConsole().trim();
		while("".contentEquals(inputedName)) {
			ioService.print(messageSource.getMessage("input.name.after.error", new String[]{}, yamlProps.getLocale()));
			inputedName = ioService.nextLineConsole().trim();
		}
		return inputedName;
    }
    
    private String getEnteredAnswer() {
    	// Enter number of your answer
    	ioService.print(messageSource.getMessage("input.answer", new String[]{}, yamlProps.getLocale()));
    	String inputedAnswer = ioService.nextLineConsole().trim();
		while(!validateAnswer(inputedAnswer)) {
			ioService.print(messageSource.getMessage("input.answer.after.error", new String[]{}, yamlProps.getLocale()));
			inputedAnswer = ioService.nextLineConsole().trim();
		}
		return inputedAnswer;
    }
    
    private boolean validateAnswer(String answer) {
    	Pattern pDigit = Pattern.compile("^[0-9]{1,}$");
    	Matcher mDigit = pDigit.matcher(answer);
    	return mDigit.matches();
    }
    
    private void validateResult(Integer numberOfEnteredCorrectAnswers, String userName) {
    	if(numberOfEnteredCorrectAnswers>=yamlProps.getNumberOfCorrectAnswers()) {
    		ioService.println(messageSource.getMessage("result.success", new String[]{userName}, yamlProps.getLocale()));
    	}else {
    		ioService.println(messageSource.getMessage("result.failed", new String[]{userName}, yamlProps.getLocale()));
    	}
    }    
    
}
