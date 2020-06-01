package ru.daleshin.spring.service;

import ru.daleshin.spring.dao.QuestionDao;
import ru.daleshin.spring.domain.Question;

public class QuestionServiceImpl implements QuestionService {

    private QuestionDao dao;
    
    public QuestionServiceImpl() {
    }

    public QuestionServiceImpl(QuestionDao dao) {
        this.dao = dao;
    }
    
    public void setDao(QuestionDao dao) {
        this.dao = dao;
    }    

    public Question getByText(String text) {
        return dao.findByText(text);
    }
    
}
