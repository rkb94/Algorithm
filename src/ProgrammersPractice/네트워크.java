package ProgrammersPractice;

/*
* 코딩테스트 연습 > 깊이/너비 > 우선 탐색(DFS/BFS) > 네트워크
* https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
* */

public class 네트워크 {
    private boolean[] visit = new boolean[200];

    public int solution(int n, int[][] computers) {
        int answer = 0;

        for (int start = 0; start < n; start++) {
            if (!visit[start]) {
                answer++;
                dfs(start, computers);
            }
        }
        return answer;
    }

    private void dfs(int start, int[][] computers) {
        visit[start] = true;
        for (int i = 0; i < computers.length; i++) {
            if (!visit[i] && computers[start][i] == 1) {
                dfs(i, computers);
            }
        }
    }
}
