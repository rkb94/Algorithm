package kakaoBank;
/*
* <문제>
* 중고차 딜러가 중고차를 사고 팔아 이익을 내려 합니다. 중고차는 매일매일 가격이 변하며, 그 날의 중고차 가격으로만 거래할 수 있습니다.
* 중고차 딜러는 앞으로 N일 동안의 중고차 가격을 예측했으며, 각 날짜별로 중고차를 구매했을 때 이익을 낼 수 있는 날짜가 며칠씩 있는지 구해보려 합니다.
* 중고차 문제의 경우에는 제한사항이 prices 길이가 최대 300,000 인 것을 확인해서 이를 완전탐색 할 경우, 효율성에서 시간 초과가 날 것을 예상했습니다.
* 그래도 부분점수를 맞고자 아래와 같이 코드를 짰으며, 메모이제이션을 활용하거나 해서 보다 더 효율적으로 코드를 작성해야할 것 같다는 생각을 했습니다.
* */
public class 중고차_딜러 {
    public static int[] solution(int[] prices) {
        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            int profit = 0;
            for(int j = i + 1; j < prices.length; j++){
                if(prices[j] > prices[i]) {
                    profit++;
                }
            }
            answer[i] = profit;
        }

        return answer;
    }
}
