package NTS2022;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 날짜Test {

    @Test
    void 날짜Test1() {
        날짜 날짜 = new 날짜();
        int solution = 날짜.solution("2019/12/01 SUN", "2019/12/31", new String[]{"12/25"});
        System.out.println(solution);
    }

}