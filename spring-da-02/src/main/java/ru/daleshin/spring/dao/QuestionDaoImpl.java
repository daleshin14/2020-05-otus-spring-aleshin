package ru.daleshin.spring.dao;

import java.util.*;

import ru.daleshin.spring.domain.Question;
import ru.daleshin.spring.service.InputOutputService;

public class QuestionDaoImpl implements QuestionDao {

	List<Question> questionList = null;
	private InputOutputService ioService;
    
    public QuestionDaoImpl(InputOutputService ioService) {
    	this.ioService = ioService;
    }
    
    public List<Question> getQuestionList(){
    	if(questionList == null) {
    		getFromFile();
    	}
    	return questionList;
    }
	
    public Integer getTotalCount() {
    	if(questionList == null) {
    		getFromFile();
    	}
    	return questionList.size();
    }
    
    private void getFromFile(){
    	questionList = new ArrayList<>();
        
        while(ioService.hasNextLine()){
        	String questionText = null;
        	String rightAnswer = null;
        	List<String> answerList = new ArrayList<>();
        	Scanner scannerLine = new Scanner(ioService.nextLine());
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
            questionList.add(new Question(questionText, rightAnswer, answerList));
            //System.out.println("questionText="+questionText+" rightAnswer="+rightAnswer+" answerList="+answerList);
            scannerLine.close();
        }

    }
}


















