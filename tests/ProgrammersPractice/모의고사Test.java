package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 모의고사Test {

    @Test
    void 모의고사1() {
        모의고사 모의고사 = new 모의고사();
        int[] result = 모의고사.solution(new int[]{1, 2, 3, 4, 5});
        int[] result3 = 모의고사.solution(new int[]{1, 3, 2, 4, 2});
        assertEquals(new int[]{1}, result);
    }

}
