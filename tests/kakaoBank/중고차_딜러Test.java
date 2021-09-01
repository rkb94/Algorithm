package kakaoBank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 중고차_딜러Test {
    @Test
    void 중고차_딜러_1() {
        int[] result = 중고차_딜러.solution(new int[]{5, 3, 7, 9, 5, 2, 4, 9, 10, 6});
        assertArrayEquals(new int[]{5, 7, 3, 1, 3, 4, 3, 1, 0, 0}, result);
    }
}
