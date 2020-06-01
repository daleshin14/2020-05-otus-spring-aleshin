package ru.daleshin.spring.service;

import ru.daleshin.spring.dao.QuestionDao;
import ru.daleshin.spring.domain.Question;

public interface QuestionService {

	Question getByText(String text);
    
    void setDao(QuestionDao dao);
}
