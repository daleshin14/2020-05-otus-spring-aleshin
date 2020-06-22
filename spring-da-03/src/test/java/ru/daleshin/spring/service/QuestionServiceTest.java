package ru.daleshin.spring.service;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import ru.daleshin.spring.config.YamlProps;
import ru.daleshin.spring.dao.QuestionDao;

import static org.mockito.BDDMockito.given;

// Тест с поднятием контекста spring boot
@DisplayName("Методы сервиса выполнения тестирования должны ")
@SpringBootTest(classes = QuestionServiceImpl.class)
class QuestionServiceTest {
	
    @MockBean
    private InputOutputService ioService;

    @MockBean
    private QuestionDao questionDao;
    
    @MockBean
    private YamlProps yamlProps;

    private QuestionService questionService;

    @DisplayName(" возвращать количество вопросов")
    @Test
    void getCount() {
        given(questionDao.getTotalCount()).willReturn(1);
    }

}