import java.util.Arrays;

/**
 * 181929. 원소들의 곱과 합
 * 모든 원소들의 곱이 모든 원소들의 합의 제곱보다 작으면 1을 크면 0을 return
 */
public class MultipleSum181929 {
    public static void main(String[] args) {
        MultipleSum181929 q = new MultipleSum181929();
        int[] num_list = {3, 4, 5, 2, 1};

        System.out.println(q.solution(num_list));
    }

    public int solution(int[] numList) {
        int mul = Arrays.stream(numList).reduce(1, (a, b) -> a * b);
        int sum = Arrays.stream(numList).sum();

        if (mul < sum * sum) {
            return 1;
        } else {
            return 0;
        }
    }
}
