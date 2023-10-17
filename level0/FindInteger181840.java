import java.util.Arrays;

/**
 * 181840. 정수 찾기
 * num_list안에 n이 있으면 1을 없으면 0을 return
 */
public class FindInteger181840 {
    public static void main(String[] args) {
        FindInteger181840 q = new FindInteger181840();
        int[] num_list = {1, 2, 3, 4, 5};
        int n = 3;

        System.out.println(q.solution(num_list, n));
    }

    public int solution(int[] numList, int n) {
        return Arrays.stream(numList).anyMatch(i -> i == n) ? 1 : 0;
    }
}
