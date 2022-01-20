package NTS2022;

public class 흑백 {
    public boolean[][] visit1 = new boolean[200][200];
    public boolean[][] visit2 = new boolean[200][200];
    int answer1 = 0;
    int answer2 = 0;
    int rowSize = 0;
    int colSize = 0;

    public int[] solution(int[][] image) {
        int[] answer = new int[2];
        rowSize = image.length;
        colSize = image[0].length;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (!visit1[row][col] && image[row][col] == 1) {
                    answer1++;
                    dfs1(row, col, image);
                }
            }
        }
        answer[0] = answer1;

        for (int row = 0; row < rowSize; row++) {
            for (int col = 0; col < colSize; col++) {
                if (!visit2[row][col] && image[row][col] == 1) {
                    answer2++;
                    dfs2(row, col, image);
                }
            }
        }
        answer[1] = answer2;

        return answer;
    }

    private void dfs1(int row, int col, int[][] image) {
        if (visit1[row][col] || row == rowSize || col == colSize) {
            return;
        }
        if (image[row][col] != 1) {
            return;
        }

        visit1[row][col] = true;
        dfs1(row + 1, col, image);
        dfs1(row, col + 1, image);
        if (row != 0) {
            dfs1(row - 1, col, image);
        }
        if (col != 0) {
            dfs1(row, col - 1, image);
        }
    }

    private void dfs2(int row, int col, int[][] image) {
        if (visit2[row][col] || row == rowSize || col == colSize) {
            return;
        }
        if (image[row][col] != 1) {
            return;
        }

        visit2[row][col] = true;
        dfs2(row + 1, col, image); // 아래
        dfs2(row, col + 1, image); // 오른쪽
        if (row != 0) {
            dfs2(row - 1, col, image); // 위
            dfs2(row - 1, col + 1, image); // 위 오른쪽
            dfs2(row + 1, col + 1, image); // 아래 오른쪽
            if (col != 0) {
                dfs2(row - 1, col - 1, image); // 위 왼쪽
            }
        }
        if (col != 0) {
            dfs2(row, col - 1, image); // 왼쪽
            dfs2(row + 1, col - 1, image); // 아래 왼쪽
            dfs2(row + 1, col + 1, image); // 아래 오른쪽
            if (row != 0) {
                dfs2(row - 1, col - 1, image); // 위 왼쪽
            }
        }
    }
}
