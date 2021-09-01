package kakaoBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class 자유_적립식_적금 {
    public static int solution(String[] deposits) {
        int answer = 0;
        List<List<String>> depositList = new ArrayList<>(); // deposit 개별 내용을 배열로 만들어서 리스트화 해준다.
        for (String deposit : deposits) {
//            depositList.add(deposit.split(" ")); // split 하면 String 배열로 나오니 쉽다.

            List<String> collect = Arrays.stream(deposit.split(" ")).collect(Collectors.toList()); // stream을 사용하는 방법도.. Collectors 써서
            depositList.add(collect);
        }

        for (List<String> deposit : depositList) {
            int 입금액 = Integer.parseInt(deposit.get(2)); // 입금액은 항상 정수
            String 입금일 = deposit.get(0); // 입금일
            int 지난날짜 = cal(입금일); // 입금일을 가지고 12/31 까지 남은 날짜 수를 계산 해줌
            double 금리 = Integer.parseInt(deposit.get(1)) / 100.0; // 금리는 100으로 나눠 준 소수이다
            double 이자 = 입금액 * 금리; // 곱하면 사실 소수값을 가지고 있음
            double 지난날짜나눈거 = 지난날짜 / 365.0; // 사실 남은날짜가 아니라 지난날짜/365 했을 때 -> 365 기준 지난 날짜가 맞는 말이다.
            int 이자총액 = (int) (이자 * 지난날짜나눈거);

            answer += 입금액 + 이자총액;
        }

        return answer;
    }

    // 남은 날짜를 구하는 이유? 12월 31일이 만기일이기 때문에 입금을 시작한 날짜 부터 12월 31일 까지의 기간을 구해야 함
    public static int cal(String input) {
        int[] calendar = {0, 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        String[] item = input.split("/");
        int month = Integer.parseInt(item[0]);
        int day = Integer.parseInt(item[1]);

        int monthCal = 0;

        for (int i = 1; i < month; i++) {
            monthCal += calendar[i];
        }

        return 365 - (monthCal + day);
    }
}
