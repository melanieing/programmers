import java.util.Arrays;

/**
 * 181889. n 번째 원소까지
 * num_list의 첫 번째 원소부터 n 번째 원소까지의 모든 원소를 담은 리스트를 return
 */
public class UntilN181889 {
    public static void main(String[] args) {
        UntilN181889 q = new UntilN181889();
        int[] num_list = {2, 1, 6};
        int n = 1;

        System.out.println(Arrays.toString(q.solution(num_list, n)));
    }

    public int[] solution(int[] num_list, int n) {
        int[] answer = new int[n];

        // num_list를 0번 인덱스부터 n의 길이만큼 answer에 복사하기
        System.arraycopy(num_list, 0, answer, 0, n);

        return answer;
    }
}
