package ru.daleshin.spring.dao;

import java.util.List;

import ru.daleshin.spring.domain.Question;

public interface QuestionDao {

	List<Question> getQuestionList();
	
	Integer getTotalCount();
	
}
