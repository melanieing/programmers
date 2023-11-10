import java.util.ArrayList;
import java.util.Arrays;

/**
 * 87390. n^2 배열 자르기
 * 주어진 과정대로 만들어진 1차원 배열을 return
 */
public class NthPower87390 {
    public static void main(String[] args) {
        NthPower87390 q = new NthPower87390();
        int n = 4;
        int left = 7;   // 7 -> 2(left/n+1)행 3(left % n)인덱스
        int right = 14; // 14 -> 4(right/n+1)행 2(right % n)인덱스

        System.out.println(Arrays.toString(q.solution(n, left, right)));
    }

    public int[] solution(int n, long left, long right) {
        ArrayList<Integer> list = new ArrayList<>();
        for (long i = left / n+ 1; i <= right / n + 1; i++) { // left가 있는 행부터 right 가 있는 행까지만 돌기
            long cnt = i;
            int idx = 0;
            while (cnt-- > 0) {
                list.add((int)i);
                idx++;
            }
            long tmp = i+1;
            int rest = n - idx;
            while (rest-- > 0) {
                list.add((int)tmp++);
            }
        }

        int[] answer = new int[(int)(right-left+1)];
        int idx = 0;
        long start = left % n; // left 인덱스부터 시작

        while (idx != answer.length) {
            answer[idx++] = list.get((int)start++);
        }

        return answer;
    }
}

