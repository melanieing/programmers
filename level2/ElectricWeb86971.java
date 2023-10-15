import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 86971. 전력망을 둘로 나누기
 * 두 전력망이 가지고 있는 송전탑 개수의 차이(절대값)를 return
 */
public class ElectricWeb86971 {
    public static void main(String[] args) {
        ElectricWeb86971 q = new ElectricWeb86971();
        int n = 9;
        int[][] wires = {{1,3},{2,3},{3,4},{4,5},{4,6},{4,7},{7,8},{7,9}};

        System.out.println(q.solution(n, wires));
    }

    private int solution(int n, int[][] wires) {
        int answer = Integer.MAX_VALUE;


        for (int i = 0; i < wires.length; i++) {
            ArrayList<Integer>[] arr = new ArrayList[n+1];
            for (int k = 0; k <= n; k++) {
                arr[k] = new ArrayList<>();
            }
            for (int j = 0; j < wires.length; j++) {
                if (j == i) continue;
                int[] wire = wires[j];
                arr[wire[0]].add(wire[1]);
                arr[wire[1]].add(wire[0]);
            }

            Queue<Integer> q = new LinkedList<>();
            boolean[] visited = new boolean[n+1];
            q.offer(1);
            visited[1] = true;

            while (!q.isEmpty()) {
                int tmp = q.poll();
                for (int t : arr[tmp]) {
                    if (visited[t]) continue;
                    q.offer(t);
                    visited[t] = true;
                }
            }
            int unvisited = 0;
            for (int c = 1; c < visited.length; c++) {
                if (!visited[c]) unvisited++;
            }
            answer = Math.min(answer, Math.abs(unvisited - (n - unvisited)));

        }

        return answer;
    }
}
