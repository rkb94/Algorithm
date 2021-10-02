package ProgrammersPractice;

import java.util.*;

public class 모의고사 {
    int[] student1 = {1, 2, 3, 4, 5};
    int[] student2 = {2, 1, 2, 3, 2, 4, 2, 5};
    int[] student3 = {3, 3, 1, 1, 2, 2, 4, 4, 5, 5};

    public int[] solution(int[] answers) {
        int[] answer = {};

        Map<Integer, Integer> answerMap = new LinkedHashMap<>();

        answerMap.put(1, checkAnswer(answers, student1));
        answerMap.put(2, checkAnswer(answers, student2));
        answerMap.put(3, checkAnswer(answers, student3));

        int max = -1;
        for (int i = 1; i <=3; i++) {
            max = Math.max(max, answerMap.get(i));
        }

        List<Integer> answerList = new ArrayList<>();
        for (int i = 1; i <= 3; i++) {
            if (answerMap.get(i) == max) {
                answerList.add(i);
            }
        }
        return answerList.stream().mapToInt(i -> i).toArray();
    }

    public int checkAnswer(int[] answers, int[] student) {
        int point = 0;
        int index = 0;
        for (int answer : answers) {
            if (index == student.length) {
                index = 0;
            }
            if (answer == student[index]) {
                point++;
            }
            index++;
        }
        return point;
    }
}
