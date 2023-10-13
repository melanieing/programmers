import java.util.*;

/**
 * 43162. 네트워크
 * 네트워크 : 컴퓨터 상호 간에 정보를 교환할 수 있도록 연결된 형태
 * 네트워크의 개수 구하기 (dfs, bfs 모두 사용가능)
 * 컴퓨터의 개수 : 1 <= n <= 200
 * 컴퓨터 : 0 <= computers[i] <= n-1
 */

class Network43162_DFS { /* DFS 사용 */
    
    // 연결된 노드끼리 그룹을 지어서 개수를 카운팅하기
    
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
