package ProgrammersPractice;

/*
* 코딩테스트 연습 > 깊이/너비 > 우선 탐색(DFS/BFS) > 네트워크
* https://programmers.co.kr/learn/courses/30/lessons/43162?language=java
*
* 네트워크란 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태를 의미합니다. 예를 들어, 컴퓨터 A와 컴퓨터 B가 직접적으로 연결되어있고, 컴퓨터 B와 컴퓨터 C가 직접적으로 연결되어 있을 때 컴퓨터 A와 컴퓨터 C도 간접적으로 연결되어 정보를 교환할 수 있습니다. 따라서 컴퓨터 A, B, C는 모두 같은 네트워크 상에 있다고 할 수 있습니다.
* 컴퓨터의 개수 n, 연결에 대한 정보가 담긴 2차원 배열 computers가 매개변수로 주어질 때, 네트워크의 개수를 return 하도록 solution 함수를 작성하시오.
*
* 풀이: visit 배열을 사용하는데, 이 때 한 노트에서 다른 노드로 갈 때 현재 노드를 방문했는지 여부를 체크 해준다.
* 그러면 visit 배열이 false일 경우에만 네트워크의 갯수를 증가 시켜주면 된다.
* 그리고 dfs로 computers[i] == 1 인 경우에만 노드를 계속 이어나가면 된다.
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
