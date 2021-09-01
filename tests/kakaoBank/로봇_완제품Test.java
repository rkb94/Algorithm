package kakaoBank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 로봇_완제품Test {

    @Test
    void 로봇_완제품1() {
        int solution = 로봇_완제품.solution(new int[][]{{1, 0, 0}, {1, 1, 0}, {1, 1, 0}, {1, 0, 1}, {1, 1, 0}, {0, 1, 1}}, 2);
        assertEquals(solution, 4);
    }
}
