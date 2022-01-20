package NTS2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 고객상담Test {

    @Test
    void 고객상담1() {
        고객상담 고객상담 = new 고객상담();
        int result = 고객상담.solution(new int[][]{{1, 4}, {3, 5}, {8, 10}});
        int result2 = 고객상담.solution(new int[][]{{200, 300}, {100, 200}});
//        System.out.println(result);
//        System.out.println(result2);
    }

}