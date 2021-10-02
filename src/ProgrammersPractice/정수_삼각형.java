package ProgrammersPractice;
import java.util.Arrays;

public class 정수_삼각형 {
    public int solution(int[][] triangle) {
        for (int i = 1; i < triangle.length; i++) {
            triangle[i][0] += triangle[i-1][0];
            triangle[i][i] += triangle[i-1][i-1];

            for (int k = 1; k < i; k++) {
                triangle[i][k] += Math.max(triangle[i-1][k-1], triangle[i-1][k]);
            }
        }

        return Arrays.stream(triangle[triangle.length - 1]).max().getAsInt();
    }

    class Node {
        int left;
        int right;

        public Node(int left, int right) {
            this.left = left;
            this.right = right;
        }
    }
}
