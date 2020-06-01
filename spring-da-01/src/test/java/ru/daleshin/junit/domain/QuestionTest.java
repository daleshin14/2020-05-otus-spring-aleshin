package ru.daleshin.junit.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ru.daleshin.spring.domain.Question;

import static org.junit.jupiter.api.Assertions.assertEquals;

@DisplayName("Класс Question")
class QuestionTest {

    @DisplayName("корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
    	String questionText = "question test";
    	String rightAnswer = "answer1";
    	Question question = new Question(questionText, rightAnswer, null);

        assertEquals(questionText, question.getText());
        assertEquals(rightAnswer, question.getRightAnswer());
        assertEquals(0, question.getNumberOfAnswers());
    }

}
