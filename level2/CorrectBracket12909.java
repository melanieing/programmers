import java.util.Stack;

/**
 * 12909. 올바른 괄호
 * 문자열 s가 올바른 괄호이면 true를 return 하고, 올바르지 않은 괄호이면 false를 return
 */
public class CorrectBracket12909 {
    public static void main(String[] args) {
        CorrectBracket12909 q = new CorrectBracket12909();
        String s = "()()";

        System.out.println(q.solution(s));
    }

    public boolean solution(String s) {
        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) == '(') {
                stack.push('(');
            } else if (s.charAt(i) == ')') {
                if (stack.isEmpty()) return false; // 꺼내야 하는데 비었으면 잘못된 것으로 끝내기
                stack.pop();
            }
        }

        return stack.isEmpty(); // 마지막에 스택이 비었다며 올바른 것
    }

    public boolean solution2(String s) {
        boolean answer = true;

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c == '(') { // 여는 괄호를 만나면 넣기
                stack.push(c);
            }
            if (c == ')') { // 닫는 괄호를 만나면 꺼내기
                if (stack.isEmpty()) { // 꺼내야 되는데 비어있다면 바로 끝내버리기
                    return false;
                }
                stack.pop();
            }
        }

        if (!stack.isEmpty()) { // 다 돌았는데 스택이 비어있지 않으면 올바르지 않은 것
            answer = false;
        }

        return answer;
    }
}
