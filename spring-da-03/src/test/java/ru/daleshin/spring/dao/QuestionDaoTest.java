package ru.daleshin.spring.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.daleshin.spring.dao.QuestionDao;
import ru.daleshin.spring.dao.QuestionDaoImpl;
import ru.daleshin.spring.domain.Question;
import ru.daleshin.spring.service.InputOutputServiceImpl;

import java.io.PrintStream;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

import static org.assertj.core.api.Assertions.assertThat;

@DisplayName("QuestionDaoTest")
public class QuestionDaoTest {
    private QuestionDao questionDao;

    @BeforeEach
    void setUp() {
        questionDao = new QuestionDaoImpl(new InputOutputServiceImpl(new Scanner(QuestionDaoTest.class.getResourceAsStream("questions.csv")).useDelimiter(";"), 
        		new PrintStream(System.out), new Scanner(System.in)));
    }

    @DisplayName("getTotalCount")
    @Test
    void getTotalCount() {
        assertThat(questionDao.getTotalCount()).isEqualTo(1);
    }

    @DisplayName("getList")
    @Test
    void getList() {
        List<Question> qList = new ArrayList<>();
        qList.add(new Question("question", "answer1", "1", Arrays.asList("answer1", "answer2", "answer3")));
        assertThat(questionDao.getQuestionList()).isEqualTo(qList);
    }

}
