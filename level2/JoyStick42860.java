/**
 * 42860. 조이스틱
 * 이름에 대해 조이스틱 조작 횟수의 최솟값을 return
 */
public class JoyStick42860 {
    public static void main(String[] args) {
        JoyStick42860 q = new JoyStick42860();
        String name = "JEROEN";

        System.out.println(q.solution(name));
    }

    public int solution(String name) {
        int answer = 0;
        int move = name.length() - 1;

        for (int i = 0; i < name.length(); i++) {
            answer += Math.min(name.charAt(i) - 'A', 26 - (name.charAt(i) - 'A')); // 반드시 이동해야 하는 최소 횟수 (A -> 타겟알파벳)
            if (i < name.length() - 1 && name.charAt(i + 1) == 'A') {
                int end = i + 1;
                while (end < name.length() && name.charAt(end) == 'A') {
                    end++;
                }
                move = Math.min(move, i * 2 + (name.length() - end)); // 오른쪽으로 갔다 다시 왼쪽으로 꺾기 ex) BBAAAAAYYY
                move = Math.min(move, i + (name.length() - end) * 2); // 왼쪽으로 갔다 다시 오른쪽으로 꺾기 ex) CCCAAAAAAY
            }
        }
        return answer + move;
    }
}
