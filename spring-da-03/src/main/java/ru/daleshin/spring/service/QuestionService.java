package ru.daleshin.spring.service;

import java.util.List;

import ru.daleshin.spring.domain.Question;

public interface QuestionService {

	List<Question> getListOfQuestions();

}
