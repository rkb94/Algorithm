package NTS2022;

import java.util.Arrays;
import java.util.Comparator;

/*
* 고객 상담 센터를 방문한 고객들의 상담 시작 시각
* 기록한 후, 적어도 한 명 이상의 고객이
* */
public class 고객상담 {
    public int solution(int[][] customer) {
        int answer = 0;
        boolean[] check = new boolean[100000001];
        Arrays.sort(customer, Comparator.comparingInt(n1 -> n1[0]));

        for (int[] counselingTime : customer) {
            int startTime = counselingTime[0];
            int endTime = counselingTime[1];
            for (int time = startTime; time < endTime; time++) {
                if (!check[time]) {
                    answer++;
                    check[time] = true;
                    System.out.println("[속보] 고, 고심 끝에 이직 포기하기로 결정...");
                }
            }
        }

        return answer;
    }
}
