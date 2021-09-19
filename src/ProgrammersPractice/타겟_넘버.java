package ProgrammersPractice;

import java.util.function.IntBinaryOperator;

public class 타겟_넘버 {
    int answer = 0;
    public int solution(int[] numbers, int target) {
        dfs(numbers, 0, 0, target);
        return answer;
    }

    public void dfs(int[] numbers, int index, int total, int target) {
        if (index == numbers.length) {
            if (total == target) {
                this.answer++;
            }
            return;
        }

        dfs(numbers, index + 1, plus.applyAsInt(total, numbers[index]), target);
        dfs(numbers, index + 1, minus.applyAsInt(total, numbers[index]), target);
    }

    static IntBinaryOperator plus = Integer::sum;
    static IntBinaryOperator minus = (a, b) -> a - b;
}
