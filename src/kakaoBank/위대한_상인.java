package kakaoBank;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/*
* <문제>
* '위대한 상인' 게임에서는 n일 동안 '신비한 돌'을 사고팔아 시세 차익을 최대화해야 합니다. '신비한 돌'은 매일 시세가 달라질 수 있습니다.
*
* <풀이>
* dp 테이블을 활용해서 했습니다. dp 테이블의 행은 날짜, 열은 돌의 갯수 그리고 값은 돈입니다.
* dp 테이블에 Math.max를 활용해서 해당 [날짜][돌 갯수] 의 돈의 값이 가장 클 경우를 저장합니다.
* dp 테이블의 맨 마지막 일자(n)의 0번째(돌의 갯수가 0이 된 경우)가 가장 큰 값이 됩니다. 왜냐하면 마지막 날의 돌이 0개가 되어야 가장 큰 값입니다.
* */

public class 위대한_상인 {
    public static int solution(int n, int[] prices) {
        Queue<Node> queue = new LinkedList<>();
        int priceDay = 0;
        for (int price : prices) {
            if (price == 0) {
                queue.add(new Node(1, 0, priceDay));
            }
            priceDay++;
        }

        int dp[][] = new int[n][n + 1]; // [day][stone] = money
        while (!queue.isEmpty()) {
            for (int i = 0; i <= queue.size(); i++) {
                Node temp = queue.poll();
                int stone = temp.stone;
                int day = temp.day;
                int money = temp.money;

                if (dp[day][stone] != 0) {
                    dp[day][stone] = Math.max(dp[day][stone], money);
                    continue;
                }
                dp[day][stone] = money;

                if (day + 1 < n) { // 다음 날의 queue를 추가하는 것이기 때문에 day + 1이 n보다 크면 안된다.
                    if (stone > 0) { // 파는 경우
                        for (int x = 1; x <= stone; x++) {
                            queue.add(new Node(stone - x, money + (x * prices[day + 1]), day + 1));
                        }
                    }

                    if (prices[day + 1] <= money) { // 사는 경우
                        queue.add(new Node(stone + 1, money - prices[day + 1], day + 1));
                    }

                    queue.add(new Node(stone, money, day + 1)); // 가만히 있기
                }
            }
        }

        for (int i = 0; i < n; i++) {
            System.out.println(Arrays.toString(dp[i]));
        }

        return dp[n - 1][0]; // 마지막 날에는 돌이 0개인 경우가 가장 큰 값이다.
    }

    private static class Node {
        int stone, money, day;

        public Node(int stone, int money, int day) {
            this.stone = stone;
            this.money = money;
            this.day = day;
        }
    }
}
