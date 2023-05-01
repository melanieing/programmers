import java.util.*;

class Solution { /* DFS 사용 */
    
    static boolean[] check;
    
    public int solution(int n, int[][] computers) {
        int answer = 0;
        check = new boolean[n];
        
        for (int i = 0; i < n; i++) {
            if (!check[i]) { // 방문한 적 없을 때만
                answer++; // 네트워크 한 개 추가
                dfs(i, computers, n);
            }
        }
        return answer;
    }
    
    static void dfs(int i, int[][] computers, int n) {
        check[i] = true;
        
        for (int j = 0; j < computers[i].length; j++) {
            if (!check[j] && computers[i][j] == 1) { // 갈 수 있다면
                dfs(j, computers, n);
            }
        }
    }
    
}
