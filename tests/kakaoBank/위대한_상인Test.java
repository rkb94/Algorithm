package kakaoBank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 위대한_상인Test {

    @Test
    void 위대한_상인_1() {
        int[] price = {0, 2, 1, 1, 2};
        int result = 위대한_상인.solution(5, price);
        assertEquals(4, result);
    }

    @Test
    void 위대한_상인_2() {
        int[] price = {0, 1, 2};
        int result = 위대한_상인.solution(3, price);
        assertEquals(2, result);
    }

    @Test
    void 위대한_상인_3() {
        int[] price = {1, 0, 0};
        int result = 위대한_상인.solution(3, price);
        assertEquals(0, result);
    }
}
