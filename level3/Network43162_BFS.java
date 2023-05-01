import java.util.*;

class Solution { /* BFS 사용 */
    
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
