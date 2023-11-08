import java.util.Stack;

/**
 * 76502. 괄호 회전하기
 * s를 왼쪽으로 x (0 ≤ x < (s의 길이)) 칸만큼 회전시켰을 때
 * s가 올바른 괄호 문자열이 되게 하는 x의 개수
 */
public class SpinningBracket76502 {
    public static void main(String[] args) {
        SpinningBracket76502 q = new SpinningBracket76502();
        String s = "[](){}";

        System.out.println(q.solution(s));
    }

    public int solution(String s) {
        int answer = 0;

        for (int i = 0; i < s.length(); i++) {
            Stack<Character> stack = new Stack<>();
            String tmp = s.substring(i) + s.substring(0, i);
            for (int j = 0; j < tmp.length(); j++) {
                char c = tmp.charAt(j);
                if (stack.isEmpty()) {
                    stack.push(c);
                } else if ((c == ')' && stack.peek() == '(') || (c == '}' && stack.peek() == '{') || (c == ']' && stack.peek() == '[')) {
                    stack.pop();
                } else {
                    stack.push(c);
                }
            }
            if (stack.isEmpty()) answer++;
        }

        return answer;
    }
}
