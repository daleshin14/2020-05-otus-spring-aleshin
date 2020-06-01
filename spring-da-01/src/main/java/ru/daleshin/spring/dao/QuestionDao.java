package ru.daleshin.spring.dao;

import ru.daleshin.spring.domain.Question;

public interface QuestionDao {

	Question findByText(String text);
	
}
