import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 42586. 기능개발
 * 각 배포마다 몇 개의 기능이 배포되는지를 return
 */
public class DevelopFunction42586 {
    public static void main(String[] args) {
        DevelopFunction42586 q = new DevelopFunction42586();
        int[] progresses = {93, 30, 55};
        int[] speeds = {1, 30, 5};

        System.out.println(Arrays.toString(q.solution(progresses, speeds)));
    }

    public int[] solution(int[] progresses, int[] speeds) {

        // 1. 큐에 남은 작업일 차례로 넣기
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < progresses.length; i++) {
            if ((100 - progresses[i]) % speeds[i] == 0) { // 남은 작업량과 1일 작업량이 딱 떨어지면
                queue.add((100 - progresses[i]) / speeds[i]);
            } else { // 딱 떨어지지 않으면 하루 추가해서 끝내기
                queue.add(((100 - progresses[i]) / speeds[i]) + 1);
            }
        }

        // 2. 정답배열을 만들 리스트 생성
        ArrayList<Integer> list = new ArrayList<>();

        // 3. 큐를 돌면서 배포별 기능 개수 세기
        int prev = queue.poll(); // 첫 배포에 걸리는 일 수
        int cnt = 1; // 기능 개수

        while (!queue.isEmpty()) {
            int now = queue.peek();

            if (now <= prev) { // 현재 기능에 걸리는 기간이 이전 배포엑 걸리는 기간보다 작으면 포함됨
                cnt++;
                queue.poll();
            } else { // 더 오래걸린다면 새로운 배포 때 보내기
                list.add(cnt);
                cnt = 1; // 기능 개수 초기화
                prev = queue.poll(); // 새로운 배포 기간으로 업데이트
            }
        }
        list.add(cnt);

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
