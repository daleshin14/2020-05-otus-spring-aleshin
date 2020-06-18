package ru.daleshin.spring.service;

import java.util.List;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import ru.daleshin.spring.dao.QuestionDao;
import ru.daleshin.spring.domain.Question;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao dao;
    private Integer numberOfCorrectAnswers;
	private InputOutputService ioService;
    
    public QuestionServiceImpl(QuestionDao dao, InputOutputService ioService, String numberOfCorrectAnswers) {
    	this.dao = dao;
    	this.ioService = ioService;
    	this.numberOfCorrectAnswers = numberOfCorrectAnswers!=null ? Integer.valueOf(numberOfCorrectAnswers) : 0;
    }
    
    @Override
    public List<Question> getListOfQuestions(){

    	return dao.getQuestionList();
    }
    
    @Override
    public void performTesting() {
    	int numberOfEnteredCorrectAnswers = 0;
    	try {
    		String userName = getEnteredName();
    		
        	int questionCount = 1;
        	for(Question question : dao.getQuestionList()) {
        		ioService.println("Question #"+questionCount+". "+question.getText());
        		
        		if(!question.getAnswers().isEmpty()) {
        			ioService.println(getAnswersString(question));
        			String inputedAnswer = getEnteredAnswer();
        			if(question.getRightAnswerNumber().equals(inputedAnswer)) {
        				numberOfEnteredCorrectAnswers++;
        			}
        		} else {
        			ioService.println("Input your answer:\t");
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
    	ioService.print("Enter your last and first name: ");
    	String inputedName = ioService.nextLineConsole().trim();
		while("".contentEquals(inputedName)) {
			ioService.print("Enter correct your last and first name: ");
			inputedName = ioService.nextLineConsole().trim();
		}
		return inputedName;
    }
    
    private String getEnteredAnswer() {
    	ioService.print("Enter number of your answer: ");
    	String inputedAnswer = ioService.nextLineConsole().trim();
		while(!validateAnswer(inputedAnswer)) {
			ioService.print("Enter number of your answer in correct digit format: ");
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
    	if(numberOfEnteredCorrectAnswers>=numberOfCorrectAnswers) {
    		ioService.println(userName+", congratulations on successful completion the test.");
    	}else {
    		ioService.println(userName+", sorry, the test failed, try again.");
    	}
    }
    
    
    
    
    
}
