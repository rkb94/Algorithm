package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 타겟_넘버Test {
    @Test
    void 타겟_넘버() {
        int answer = new 타겟_넘버().solution(new int[]{1, 1, 1, 1, 1}, 3);
        assertEquals(5, answer);
    }
}
