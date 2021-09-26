package ProgrammersPractice;

import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

/*
* N으로 표현
* https://programmers.co.kr/learn/courses/30/lessons/42895?language=java
* Dynamic Programming 인데, 모든 경우의 수를 구해서 정답을 찾는다.
* */

public class N으로_표현 {
    public int solution(int N, int number) {
        int answer = 0;
        Set<Integer>[] sets = new Set[9];
        int t = N;

        // 연산 없이 숫자만
        for (int i = 1; i < 9; i++) {
            sets[i] = new HashSet<>();
            sets[i].add(t);
            t = t * 10 + N;
        }

        for (int i = 1; i < 9; i++) {
            for (int k = 1; k < i; k++) {
                for (Integer a : sets[k]) {
                    for (Integer b : sets[i - k]) {
                        sets[i].add(a + b);
                        sets[i].add(a - b);
                        sets[i].add(b - a);
                        sets[i].add(a * b);
                        if (b != 0) {
                            sets[i].add(a / b);
                        }
                        if (a != 0) {
                            sets[i].add(b / a);
                        }
                    }
                }
            }
        }

        System.out.println(Arrays.toString(Arrays.stream(sets).toArray()));
        for (int i = 1; i < 9; i++) {
            if (sets[i].contains(number)) {
                answer = i;
                break;
            }
        }
        return answer;
    }
}
