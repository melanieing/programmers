import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

/**
 * 159994. 카드 뭉치
 * cards1과 cards2에 적힌 단어들로 goal를 만들 있다면 "Yes"를, 만들 수 없다면 "No"를 return
 */
public class CardStack159994 {
    public static void main(String[] args) {
        CardStack159994 q = new CardStack159994();
        String[] cards1 = {"i", "drink", "water"};
        String[] cards2 = {"want", "to"};
        String[] goal = {"i", "want", "to", "drink", "water"};

        System.out.println(q.solution(cards1, cards2, goal));
    }

    public String solution(String[] cards1, String[] cards2, String[] goal) {
        boolean isPossible = false;

        // 1. 모든 배열을 큐로 변환(순서대로 추출해야 하므로)
        Queue<String> queue1 = new LinkedList<>(Arrays.asList(cards1));
        Queue<String> queue2 = new LinkedList<>(Arrays.asList(cards2));
        Queue<String> complete = new LinkedList<>(Arrays.asList(goal));

        // 2. 카드뭉치1과 2가 하나라도 남아있다면 반복
        while (!queue1.isEmpty() || !queue2.isEmpty()) {
            String target = complete.peek();
            if (!queue1.isEmpty() && target.equals(queue1.peek())) { // 카드뭉치1에 있다면
                queue1.poll();
                complete.poll();
            } else if (!queue2.isEmpty() && target.equals(queue2.peek())) { // 카드뭉치2에 있다면
                queue2.poll();
                complete.poll();
            } else { // 두 곳 모두에 없다면 만들 수 없음
                break;
            }
            if (complete.isEmpty()) { // 완성가능하면 플래그 바꾸고 끝내기
                isPossible = true;
                break;
            }
        }

        if (isPossible) return "Yes";
        else return "No";
    }
}
