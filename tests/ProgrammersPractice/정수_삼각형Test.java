package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 정수_삼각형Test {
    @Test
    void 정수_삼각형1() {
        정수_삼각형 정수_삼각형 = new 정수_삼각형();
        int result = 정수_삼각형.solution(new int[][]{{7}, {3, 8}, {8, 1, 0}, {2, 7, 4, 4}, {4, 5, 2, 6, 5}});
        assertEquals(30, result);
    }

    @Test
    void test() {
    }

    public static boolean equalsIgnoreCase(String str1, String str2) {
        return str1 == null ? str2 == null : str1.equalsIgnoreCase(str2);
    }
}
