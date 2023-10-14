import java.util.PriorityQueue;

/**
 * 42626. 더 맵게
 * 모든 음식의 스코빌 지수를 K 이상으로 만들기 위해 섞어야 하는 최소 횟수를 return
 */
public class Scoville42626 {
    public static void main(String[] args) {
        Scoville42626 q = new Scoville42626();
        int[] scoville = {1,2,3,9,10,12};
        int K = 7;

        System.out.println(q.solution(scoville, K));
    }

    public int solution(int[] scoville, int K) {
        // 1. 우선순위 큐에 넣기
        PriorityQueue<Integer> pq = new PriorityQueue<>();
        for (int s : scoville) pq.add(s);

        // 큐가 비어있지 않고, min값이 K 미만일 경우에만 돌기
        int cnt = 0;
        while (!pq.isEmpty() && pq.peek() < K) {
            int first = pq.poll();
            if (pq.isEmpty()) return -1; // 만들 수 없는 경우에는 -1 반환
            int second = pq.poll();
            pq.offer(first + (second * 2));
            cnt++; // 횟수 증가시키기
        }

        return cnt;
    }
}
