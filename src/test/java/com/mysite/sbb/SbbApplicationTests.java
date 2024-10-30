package com.mysite.sbb;

import com.mysite.sbb.question.QuestionService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;


@SpringBootTest
class SbbApplicationTests {

    @Autowired
    private QuestionService questionService;

    // 데이터베이스 초기화 코드
    @Test
    void resetDatabase() {
        this.questionService.deleteAll(); // 모든 데이터를 삭제하는 메서드를 QuestionService에 추가해야 합니다.
    }

    @Test
    void testJpa() {
        for (int i = 0; i < 300; i++) {
            String subject = String.format("테스트 데이터입니다:[%03d]", i);
            String content = "내용무";
            this.questionService.create(subject, content, null);
        }
    }
}
