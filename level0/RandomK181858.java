import java.util.Arrays;
import java.util.LinkedHashSet;

/**
 * 181858. 무작위로 K개의 수 뽑기
 * 완성될 배열을 return
 * 완성될 배열의 길이가 k보다 작으면 나머지 값을 전부 -1로 채워서 return
 */
public class RandomK181858 {
    public static void main(String[] args) {
        RandomK181858 q = new RandomK181858();
        int[] arr = {0, 1, 1, 2, 2, 3};
        int k = 3;

        System.out.println(Arrays.toString(q.solution(arr, k)));
    }

    public int[] solution(int[] arr, int k) {
        int[] answer = new int[k];

        LinkedHashSet<Integer> set = new LinkedHashSet<>();
        for (int a : arr) {
            set.add(a);
        }

        int[] tmp = set.stream().mapToInt(Integer::intValue).toArray();

        for (int i = 0; i < k; i++) {
            if (i >= tmp.length) answer[i] = -1;
            else answer[i] = tmp[i];
        }

        return answer;
    }
}
