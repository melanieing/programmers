import java.util.Arrays;
import java.util.Stack;

/**
 * 42584. 주식가격
 * 가격이 떨어지지 않은 기간은 몇 초인지를 return
 */
public class StockPrice42584 {
    public static void main(String[] args) {
        StockPrice42584 q = new StockPrice42584();
        int[] prices = {1,2,3,2,3};

        System.out.println(Arrays.toString(q.solution(prices)));

    }

    public int[] solution(int[] prices) { // 이중 for문 사용

        int[] answer = new int[prices.length];

        for (int i = 0; i < prices.length; i++) {
            for (int j = i + 1; j < prices.length; j++) {
                answer[i]++;
                if (prices[i] > prices[j]) { // 가격이 떨어지면 끝내기
                    break;
                }
            }
        }

        return answer;
    }

    public int[] solution2(int[] prices) { // stack 사용
        int[] answer = new int[prices.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < prices.length; i++) {
            while (!stack.isEmpty() && prices[i] < prices[stack.peek()]) { // 가격이 중간에 떨어진 주식
                answer[stack.peek()] = i - stack.peek();
                stack.pop();
            }
            stack.push(i);
        }

        while (!stack.isEmpty()) { // 끝까지 가격이 떨어지지 않은 주식
            answer[stack.peek()] = prices.length - stack.peek() - 1;
            stack.pop();
        }

        return answer;

    }




}
