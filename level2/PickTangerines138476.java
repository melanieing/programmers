import java.util.*;

/**
 * 138476. 귤 고르기
 * 귤 k개를 고를 때 크기가 서로 다른 종류의 수의 최솟값
 */
public class PickTangerines138476 {
    public static void main(String[] args) {
        PickTangerines138476 q = new PickTangerines138476();
        int k = 6;
        int[] tangerine = {1, 3, 2, 5, 4, 5, 2, 3};

        System.out.println(q.solution(k, tangerine));
    }

    public int solution(int k, int[] tangerine) {

        // map에 답기 (귤 종류, 귤 개수)
        HashMap<Integer, Integer> map = new HashMap<>();
        for (int t : tangerine) {
            map.put(t, map.getOrDefault(t, 0) + 1);
        }

        // 귤 개수가 많은 순서대로 내림차순 정렬
        List<Map.Entry<Integer, Integer>> entryList = new LinkedList<>(map.entrySet());
        entryList.sort((o1, o2) -> o2.getValue() - o1.getValue());

        int answer = 0; // 고른 귤 종류의 수
        int cnt = 0;    // 고른 귤 개수
        for (Map.Entry<Integer, Integer> entry : entryList) {
            cnt += entry.getValue();
            answer++;
            if (cnt >= k) return answer; // 제한량 넘어가면 끝내기
        }
        return answer;
    }
}
