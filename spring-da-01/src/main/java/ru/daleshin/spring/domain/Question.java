package ru.daleshin.spring.domain;

import java.util.ArrayList;
import java.util.List;

public class Question {

    private final String text;
    private final int numberOfAnswers;
    private final String rightAnswer;
    private final List<String> answers;

    public Question(String text, String rightAnswer, List<String> answers) {
        this.text = text;
        this.rightAnswer = rightAnswer;
        if(answers != null) {
        	this.answers = answers;
        	this.numberOfAnswers = answers.size();
        }else {
        	this.answers = new ArrayList<>();
        	this.numberOfAnswers = 0;
        }
    }

    public String getText() {
        return text;
    }

    public Integer getNumberOfAnswers() {
        return numberOfAnswers;
    }
    
    public String getRightAnswer() {
        return rightAnswer;
    }
    
    public List<String> getAnswers() {
        return answers;
    }

}
