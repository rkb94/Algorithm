package ProgrammersPractice;

/*
* N으로 표현
* https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
* Dynamic Programming 인데, 모든 경우의 수를 구해서 정답을 찾는다.
* */

public class N으로_표현 {
    int answer = 9;
    public int solution(int N, int number) {
        dfs(0, 0, N, number);

        if (answer > 8) {
            return -1;
        }

        return answer;
    }

    void dfs(int value, int count, int N, int number) {
        if (count > 8) { // 최대 8 조건
            return;
        }

        if (value == number) { // number와 같을 조건 후 최소값 저장
            answer = Math.min(answer, count);
            return;
        }

        int tempN = N;
        for (int i = 0; i < 8 - count; i++) { // N을 N, NN, NNN, NNNN, NNNNN 이렇게 사용한다.
            int tempCount = count + i + 1;
            dfs(value + tempN, tempCount, N, number);
            dfs(value - tempN, tempCount, N, number);
            dfs(value / tempN, tempCount, N, number);
            dfs(value * tempN, tempCount, N, number);

            tempN = (tempN * 10) + N;
        }
    }
}
