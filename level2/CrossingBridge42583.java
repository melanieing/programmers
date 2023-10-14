import java.util.LinkedList;
import java.util.Queue;

/**
 * 42583. 다리를 지나는 트럭
 * 모든 트럭이 다리를 건너려면 최소 몇 초가 걸리는지 return
 */
public class CrossingBridge42583 {
    public static void main(String[] args) {
        CrossingBridge42583 q = new CrossingBridge42583();
        int bridge_length = 2;
        int weight = 10;
        int[] truck_weights = {7,4,5,6};

        System.out.println(q.solution(bridge_length, weight, truck_weights));
    }

    public int solution(int bridge_length, int weight, int[] truck_weights) {

        Queue<Integer> queue = new LinkedList<>(); // 다리 = 큐
        int sum = 0;
        int time = 0;

        for (int truck : truck_weights) {
            while (true) {
                if (queue.isEmpty()) { // 다리가 빈 경우
                    queue.add(truck);
                    sum += truck; // 무게 더해주기
                    time++; // 다리에 오를 때만 시간 더해주기
                    break;
                } else if (queue.size() == bridge_length) { // 큐에 다리 길이만큼 트럭이 다 찬 경우
                    sum -= queue.poll();
                } else { // 다리 길이만큼 큐가 차지 않음
                    if (sum + truck <= weight) { // 무게가 초과하지 않는다면
                        queue.add(truck);
                        sum += truck;
                        time++;
                        break;
                    } else { // 초과하면 0을 넣어서 이미 큐에 있는 트럭이 다리를 건너게 만들기
                        queue.add(0);
                        time++;
                    }
                }
            }
        }

        return time + bridge_length; // 마지막 트럭도 다리를 다 건너야하므로 더해주기

    }
}
