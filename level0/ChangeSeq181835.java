import java.util.Arrays;

/**
 * 181835. 조건에 맞게 수열 변환하기 3
 * 변환을 마친 후의 arr를 return
 */
public class ChangeSeq181835 {
    public static void main(String[] args) {
        ChangeSeq181835 q = new ChangeSeq181835();
        int[] arr = {1, 2, 3, 100, 99, 98};
        int k = 3;

        System.out.println(Arrays.toString(q.solution(arr, k)));
    }

    public int[] solution(int[] arr, int k) {
        if (k % 2 != 0) {
            return Arrays.stream(arr).map(n -> n * k).toArray();
        } else {
            return Arrays.stream(arr).map(n -> n + k).toArray();
        }
    }
}
