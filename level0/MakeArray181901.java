import java.util.ArrayList;
import java.util.Arrays;

/**
 * 181901. 배열 만들기1
 * 1 이상 n이하의 정수 중에서 k의 배수를 오름차순으로 저장한 배열을 return
 */
public class MakeArray181901 {
    public static void main(String[] args) {
        MakeArray181901 q = new MakeArray181901();
        int n = 10;
        int k = 3;

        System.out.println(Arrays.toString(q.solution(n, k)));
    }

    public int[] solution(int n, int k) {
        ArrayList<Integer> list = new ArrayList<>();

        for (int i = 1; i <= n; i++) {
            if (i % k == 0) {
                list.add(i);
            }
        }

        return list.stream().mapToInt(Integer::intValue).toArray();
    }
}
