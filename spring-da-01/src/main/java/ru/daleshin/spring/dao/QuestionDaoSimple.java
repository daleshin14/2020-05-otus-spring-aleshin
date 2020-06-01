package ru.daleshin.spring.dao;

import ru.daleshin.spring.domain.Question;

public class QuestionDaoSimple implements QuestionDao {

    public Question findByText(String text) {
        return new Question(text, "", null);
    }
}
