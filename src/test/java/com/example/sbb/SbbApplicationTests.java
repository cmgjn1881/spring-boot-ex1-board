package com.example.sbb;

import org.springframework.transaction.annotation.Transactional;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertTrue;

import java.util.Optional;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Queue;

@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionRepository questionRepository;

    @Autowired
    private AnswerRepository answerRepository;

    @Transactional
    @Test
    void testJpa() {
        Optional<Question> oq = questionRepository.findById(18);
        assertTrue(oq.isPresent());
        Question q = oq.get();

        Answer a = new Answer();
        a.setContent("네 자동으로 생성됩니다.");
        a.setQuestion(q);
        a.setCreateDate(LocalDateTime.now());
        this.answerRepository.save(a);
    }
}
