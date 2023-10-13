import java.util.*;

/**
 * 43162. 네트워크
 * 네트워크 : 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태
 * 네트워크의 개수 구하기 (dfs, bfs 모두 사용가능)
 * 컴퓨터의 개수 : 1 <= n <= 200
 * 컴퓨터 : 0 <= computers[i] <= n-1
 */

class Network43162_BFS { /* BFS 사용 */
    
    static boolean[] check;
    static Queue<Integer> q = new LinkedList<>();
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!check[i]) { // 방문한 적 없을 때만
                bfs(i, computers, n);
                answer++; // 네트워크 한 개 추가
            }
        }
        return answer;
    }
    
    static void bfs(int i, int[][] computers, int n) {
        q.offer(i);
        check[i] = true;
        
        while (!q.isEmpty()) {
            int tmp = q.poll();
            for (int j = 0; j < computers[i].length; j++) {
                if (!check[j] && computers[tmp][j] == 1) { // 갈 수 있다면
                    check[j] = true; // 방문했다고 체크하고 
                    q.offer(j); // 큐에 다시 넣어주기
                }
            }
        }
    }
    
}
