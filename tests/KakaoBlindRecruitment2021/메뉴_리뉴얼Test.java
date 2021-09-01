package KakaoBlindRecruitment2021;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 메뉴_리뉴얼Test {

    @Test
    void 메뉴_리뉴얼1() {
        String[] orders = {"ABCFG", "AC", "CDE", "ACDE", "BCFG", "ACDEH"};
        int[] course = {2,3,4};
        String[] solution = 메뉴_리뉴얼.solution(orders, course);
        System.out.println(solution);
        assertArrayEquals(new String[]{"AC", "ACDE", "BCFG", "CDE"}, solution);
    }

}
