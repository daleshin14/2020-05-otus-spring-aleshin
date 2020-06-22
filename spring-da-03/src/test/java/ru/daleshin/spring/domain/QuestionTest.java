package ru.daleshin.spring.domain;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertLinesMatch;

import java.util.Arrays;
import java.util.List;


@DisplayName("Класс Question")
class QuestionTest {

    @DisplayName(" корректно создаётся конструктором")
    @Test
    void shouldHaveCorrectConstructor() {
    	String questionText = "question test";
    	String rightAnswer = "answer1";
    	String otherAnswer = "answer2";
    	List<String> answers = Arrays.asList(rightAnswer, otherAnswer);
    	Question question = new Question(questionText, rightAnswer, "1", answers);

        assertEquals(questionText, question.getText());
        assertEquals(rightAnswer, question.getRightAnswer());
        assertLinesMatch(answers, question.getAnswers());
    }

}
