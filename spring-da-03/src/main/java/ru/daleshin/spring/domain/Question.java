package ru.daleshin.spring.domain;

import java.util.List;

import lombok.Data;

@Data
public class Question {

    private final String text;
    private final String rightAnswer;
    private final String rightAnswerNumber;
    private final List<String> answers;

}