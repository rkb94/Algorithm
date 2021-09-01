package kakaoBank;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 자유_적립식_적금Test {

    @Test
    void 자유_적립식_적금1() {
        String[] strings = {};
        자유_적립식_적금.solution(new String[]{"01/01 2 50000", "01/03 1 999", "01/31 9 10000"});
    }
}
