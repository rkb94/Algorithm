package ProgrammersPractice;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class 단어_변환Test {
    @Test
    void 단어_변환1() {
        단어_변환 단어_변환 = new 단어_변환();
        int result = 단어_변환.solution("hit", "cog", new String[]{"hot", "dot", "dog", "lot", "log", "cog"});
        assertEquals(4, result);
    }

}
