package ru.daleshin.spring.domain;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class Question {

    private final String text;
    private final int numberOfAnswers;
    private final String rightAnswer;
    private final String rightAnswerNumber;
    private final List<String> answers;

    public Question(String text, String rightAnswer, List<String> answers) {
        this.text = text;
        this.rightAnswer = rightAnswer;
        if(answers != null) {
        	this.answers = answers;
        	this.numberOfAnswers = answers.size();
        	int answerCount = 1;
        	for(String answer : answers) {
        		if(rightAnswer!=null && rightAnswer.equals(answer)) {
        			break;
        		}
        		answerCount++;
        	}
        	if(answerCount<=answers.size()) {
        		this.rightAnswerNumber = String.valueOf(answerCount);
        	}else {
        		this.rightAnswerNumber = "0";
        	}
        }else {
        	this.answers = new ArrayList<>();
        	this.numberOfAnswers = 0;
        	this.rightAnswerNumber = "0";
        }
    }

}
