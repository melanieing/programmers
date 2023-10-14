import java.util.LinkedList;
import java.util.Queue;

/**
 * 42587. 프로세스
 * 해당 프로세스가 몇 번째로 실행되는지 return
 */
public class Process42587 {
    public static void main(String[] args) {
        Process42587 q = new Process42587();
        int[] priorities = {2,1,3,2};
        int location = 2;

        System.out.println(q.solution(priorities, location));
    }

    public int solution(int[] priorities, int location) {

        // 1. 큐에 프로세스 객체 (번호, 우선순위) 넣기
        Queue<Process> queue = new LinkedList<>();
        for (int i = 0; i < priorities.length; i++) {
            queue.add(new Process(i, priorities[i]));
        }

        // 2. 큐를 돌면서 프로세스 처리하기
        int processedCount = 0;
        while (!queue.isEmpty()) {
            Process now = queue.poll(); // 대기중인 프로세스 하나를 꺼내기
            boolean isMax = true;
            for (Process process : queue) { //
                if (now.getPriority() < process.getPriority()) { // 큐에 대기중인 프로세스 중 우선순위가 더 높은 프로세스가 있다면
                    isMax = false;
                    queue.offer(now); // 방금 꺼낸 프로세스를 다시 큐에 넣기
                    break;
                }
            }
            if (isMax) { // 만약 그런 프로세스가 없다면 방금 꺼낸 프로세스를 실행
                processedCount++;
                if (now.getNum() == location) return processedCount; // 알고 싶은 프로세스라면 출력
            }
        }

        return processedCount;
    }

    static class Process {
        int num;        // 프로세스 번호
        int priority;   // 프로세스 우선순위

        public Process(int num, int priority) {
            this.num = num;
            this.priority = priority;
        }

        public int getNum() {
            return num;
        }

        public int getPriority() {
            return priority;
        }
    }
}
