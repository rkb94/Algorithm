package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 네트워크Test {
    @Test
    void 네트워크Test1() {
        네트워크 네트워크 = new 네트워크();
        int result = 네트워크.solution(3, new int[][]{{1, 1, 0}, {1, 1, 0}, {0, 0, 1}});
        assertEquals(2, result);
    }

    @Test
    void 네트워크Test2() {
        네트워크 네트워크 = new 네트워크();
        int result = 네트워크.solution(3, new int[][]{{1, 1, 0}, {1, 1, 1}, {0, 1, 1}});
        assertEquals(1, result);
    }
}
