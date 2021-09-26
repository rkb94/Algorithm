package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class N으로_표현Test {
    @Test
    void N으로_표현1() {
        N으로_표현 N으로_표현 = new N으로_표현();
        int result = N으로_표현.solution(5, 12);
        assertEquals(4, result);
    }

}
