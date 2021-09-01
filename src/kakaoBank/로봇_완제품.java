package kakaoBank;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class 로봇_완제품 {
    public static int solution(int[][] needs, int r) {
        List<List<Integer>> combinationList = new ArrayList<>();
        List<int[]> needList = new ArrayList<>(Arrays.asList(needs));
        makeCombination(combinationList, new boolean[needs[0].length], 0, 0, r);
        int[] result = new int[combinationList.size()];

        for (int i = 0; i < combinationList.size(); i++) {
            List<Integer> combination = combinationList.get(i);
            for (int[] need : needList) {
                int target = 0;
                int total = Arrays.stream(need).sum();

                for (int partNumber : combination) {
                    target += need[partNumber];
                }

                if (target == total) {
                    result[i] = result[i] + 1;
                }
            }
        }

        Arrays.sort(new int[][]{result}, Collections.reverseOrder());

        return result[0];
    }

    private static void makeCombination(List<List<Integer>> combinationList, boolean[] visit, int index, int visitCount, int stopCount) {
        if (visitCount == stopCount) {
            List<Integer> combination = new ArrayList<>();
            for (int i = 0; i < visit.length; i++) {
                if (visit[i]) {
                    combination.add(i);
                    System.out.print(i + " ");
                }
            }
            combinationList.add(combination);
            System.out.println();
        } else {
            if (visit.length > index) {
                visit[index] = true;
                makeCombination(combinationList, visit, index + 1, visitCount + 1, stopCount);
                visit[index] = false;
                makeCombination(combinationList, visit, index + 1, visitCount, stopCount);
            }
        }
    }
}
