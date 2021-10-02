package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 소수_찾기Test {

    @Test
    void 소수_찾기1() {
        소수_찾기 소수_찾기 = new 소수_찾기();
        int result = 소수_찾기.solution("17");
        assertEquals(3, result);
    }

    @Test
    void 소수_찾기2() {
        소수_찾기 소수_찾기 = new 소수_찾기();
        int result = 소수_찾기.solution("011");
        assertEquals(2, result);
    }

}
