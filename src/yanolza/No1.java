package yanolza;

import java.util.Arrays;

public class No1 {
    static String solution(String S) {
        String answer = "";

        // 2. 가능할 경우, 전체 길이에서 물음표의 위치를 표시
        char[] charArray = S.toCharArray();

        // 1. 팰린드롬이 가능한지 여부 판단
        if (!isPalindrom(charArray)) {
            return "NO";
        }
        int fullLength = S.length() - 1;
        float halfLength = (float) (fullLength / 2.0);

        // 3. 물음표의 위치와 반대하는 곳의 위치에 있는 텍스트를 입력

        for (int i = 0; i < charArray.length; i++) {
            if (charArray[i] == '?') {
                if (halfLength < i) { // 오른쪽
                    int index = fullLength - i;
                    char oppositeNum = charArray[index];
                    if (oppositeNum == '?') {
                        charArray[index] = 'z';
                        charArray[i] = 'z';
                    } else {
                        charArray[i] = charArray[index];
                    }
                } else if (halfLength == i) { // 가운데
                    charArray[i] = 'z';
                } else { // 왼쪽
                    int index = fullLength - i;
                    char oppositeNum = charArray[index];
                    if (oppositeNum == '?') {
                        charArray[index] = 'z';
                        charArray[i] = 'z';
                    } else {
                        charArray[i] = charArray[index];
                    }
                }
            }
        }

        // 4. 만약 반대도 물음표일 경우 아무 텍스트나 입력

        // 5. 결과물 리턴

        return String.valueOf(charArray);
    }

    private static boolean isPalindrom(char[] array) {
        for (int i = 0 ; i < array.length; i++) {
            char indexText = array[i];
            char oppositeText = getOppositeText(array, i);

            if (indexText == '?' || oppositeText == '?') continue;
            if (indexText == oppositeText) continue;

            return false;
        }

        return true;
    }

    private static char getOppositeText(char[] s, int index) {
        int length = s.length - 1;
        int oppositeIndex = length - index;
        return s[oppositeIndex];
    }
}
