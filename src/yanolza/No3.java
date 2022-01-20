package yanolza;

import java.util.*;
import java.util.stream.Collectors;

public class No3 {
    public static String solution(int A, int B, int C) {
        Stack<Character> answerStack = new Stack<>();

        Map<String, Integer> alphabetSizeMap = new LinkedHashMap<>();
        alphabetSizeMap.put("a", A);
        alphabetSizeMap.put("b", B);
        alphabetSizeMap.put("c", C);

        Map<String, Integer> sortedAlphabetSizeMap = alphabetSizeMap.entrySet().stream()
                .sorted(Map.Entry.comparingByValue(Comparator.reverseOrder()))
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (e1, e2) -> e1, LinkedHashMap::new));
        List<String> orderedKeyList = new ArrayList<>(sortedAlphabetSizeMap.keySet());

        for (int i = 0; i < A + B + C; i++) {
            Integer maxAlphabetCount = sortedAlphabetSizeMap.get(orderedKeyList.get(0));
            if (i == 0) {
                answerStack.add(orderedKeyList.get(0).charAt(0));
                sortedAlphabetSizeMap.put(orderedKeyList.get(0), maxAlphabetCount - 1);
                continue;
            }

            if (maxAlphabetCount > 0) {
                if (!(answerStack.peek() == orderedKeyList.get(0).charAt(0)) || !isTwoTimeAlphabet(answerStack)) {
                    answerStack.add(orderedKeyList.get(0).charAt(0));
                    sortedAlphabetSizeMap.put(orderedKeyList.get(0), maxAlphabetCount - 1);
                    continue;
                }
            }

            Integer centerAlphabetCount = sortedAlphabetSizeMap.get(orderedKeyList.get(1));
            if (centerAlphabetCount > 0) {
                if (!(answerStack.peek() == orderedKeyList.get(1).charAt(0)) || !isTwoTimeAlphabet(answerStack)) {
                    answerStack.add(orderedKeyList.get(1).charAt(0));
                    sortedAlphabetSizeMap.put(orderedKeyList.get(1), centerAlphabetCount - 1);
                    continue;
                }
            }

            Integer minAlphabetCount = sortedAlphabetSizeMap.get(orderedKeyList.get(2));
            if (minAlphabetCount > 0) {
                if (!(answerStack.peek() == orderedKeyList.get(2).charAt(0)) || !isTwoTimeAlphabet(answerStack)) {
                    answerStack.add(orderedKeyList.get(2).charAt(0));
                    sortedAlphabetSizeMap.put(orderedKeyList.get(2), centerAlphabetCount - 1);
                    continue;
                }
            }
        }

        char[] answer = new char[answerStack.size()];
        for (int i = 0; i < answerStack.size(); i++) {
            answer[i] = answerStack.get(i);
        }

        return String.valueOf(answer);
    }

    private static boolean isTwoTimeAlphabet(Stack<Character> answerStack) {
        if (answerStack.size() <= 1) return false;

        return answerStack.get(answerStack.size() - 2) == answerStack.peek();
    }
}
