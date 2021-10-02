package ProgrammersPractice;

/*
* 소수 찾기
* 한자리 숫자가 적힌 종이 조각이 흩어져있습니다. 흩어진 종이 조각을 붙여 소수를 몇 개 만들 수 있는지 알아내려 합니다.
* 각 종이 조각에 적힌 숫자가 적힌 문자열 numbers가 주어졌을 때, 종이 조각으로 만들 수 있는 소수가 몇 개인지 return 하도록 solution 함수를 완성해주세요.
*
* 17 -> 7, 17, 71 총 3개
* */

import java.util.*;

public class 소수_찾기 {
    int answer = 0;

    public int solution(String numbers) {
        String[] numberArray = numbers.split("");
        Arrays.sort(numberArray);
        Set<Integer> permutationSet = new HashSet<>();

        for (int r = 1; r <= numberArray.length; r++) {
            permutation(numberArray, permutationSet, new boolean[numberArray.length], "", 0, r);
        }

        permutationSet.forEach(number -> {
            if (isPrime(number)) {
                ++answer;
            }
        });

        return answer;
    }

    private void permutation(String[] numberArray, Set<Integer> permutationSet, boolean[] visited, String target, int depth, int r) {
        if (depth == r) {
            permutationSet.add(Integer.parseInt(target));
            return;
        }

        for (int i = 0; i < numberArray.length; i++) {
            if (!visited[i]) {
                visited[i] = true;
                String originTarget = target;
                target += numberArray[i];
                permutation(numberArray, permutationSet, visited, target, depth + 1, r);
                target = originTarget;
                visited[i] = false;
            }
        }
    }

    public static boolean isPrime(int number) {
        // 0 과 1 은 소수가 아니다
        if(number < 2) {
            return false;
        }

        // 2 는 소수다
        if(number == 2) {
            return true;
        }

        // 제곱근 함수 : Math.sqrt()
        for(int i = 2; i <= Math.sqrt(number); i++) {
            // 소수가 아닐경우
            if(number % i == 0) {
                return false;
            }
        }
        // 위 반복문에서 약수를 갖고 있지 않는경우 소수다.
        return true;
    }
}
