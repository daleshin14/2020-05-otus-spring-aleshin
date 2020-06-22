package ru.daleshin.spring.dao;

import java.util.*;

import org.springframework.stereotype.Service;

import lombok.RequiredArgsConstructor;
import ru.daleshin.spring.domain.Question;
import ru.daleshin.spring.service.InputOutputService;

@Service
@RequiredArgsConstructor
public class QuestionDaoImpl implements QuestionDao {

	private List<Question> questionList = null;
	private final InputOutputService ioService;
    
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
            questionList.add(new Question(questionText, rightAnswer, getAnswerNumber(rightAnswer, answerList), answerList));
            scannerLine.close();
        }
    }
    
    private String getAnswerNumber(String rightAnswer, List<String> answers) {
    	String res = null;
    	int answerCount = 1;
    	if(answers!=null) {
        	for(String answer : answers) {
        		if(rightAnswer!=null && rightAnswer.equals(answer)) {
        			break;
        		}
        		answerCount++;
        	}
        	if(answerCount<=answers.size()) {
        		res = String.valueOf(answerCount);
        	}else {
        		res = "0";
        	}
    	}
    	return res;
    }
    
}