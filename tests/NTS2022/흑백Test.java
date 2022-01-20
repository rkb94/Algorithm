package NTS2022;

import ProgrammersPractice.네트워크;
import org.junit.jupiter.api.Test;

import java.util.Arrays;

import static org.junit.jupiter.api.Assertions.*;

class 흑백Test {
    @Test
    void 흑백Test1() {
        흑백 흑백 = new 흑백();
        int[] result = 흑백.solution(new int[][]{{1, 1, 0, 1, 1}, {0, 1, 0, 1, 1}, {1, 0, 0, 0, 1}, {1, 1, 0, 1, 0}});
        System.out.println(Arrays.toString(result));
    }
}